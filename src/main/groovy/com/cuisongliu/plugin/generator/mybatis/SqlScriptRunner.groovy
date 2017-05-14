/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 cuisongliu@qq.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cuisongliu.plugin.generator.mybatis

import com.alibaba.druid.pool.DruidDataSource
import org.gradle.api.GradleException
import org.mybatis.generator.internal.util.StringUtility

import java.sql.Connection
import java.sql.Statement

/**
 * <p>ProjectName: gradle-plugin</p>
 * <p>Package: com.cuisongliu.plugin.generator.mybatis</p>
 * <p>ClassName: GradleProgressCallback.groovy</p>
 * <p>Description: This class is jdbc running of sqlScript  file implementation.</p>
 * <p>Copyright (c) 2017 cuisongliu@qq.com</p>
 * @author cuisongliu
 * @version 1.0 创建时间：2017年5月10日 20:06:20
 */
class SqlScriptRunner {
    private String url
    private String username
    private String password
    private String sqlScript

    SqlScriptRunner(String sqlScript, String url, String username, String password) {
        this.url = url
        this.username = username
        this.password = password
        this.sqlScript = sqlScript
    }

    void execSqlScript() {
        if (sqlScript == null) {
            println("sqlScript未设置,执行Sql任务跳过.")
            return;
        }
        DruidDataSource dataSource
        Connection con
        try {
            dataSource = new DruidDataSource()
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            con = dataSource.getConnection()
            println("开始执行SQL操作.")
            con.setAutoCommit(false)
            def execSql
            Statement statement = con.createStatement();
            BufferedReader br = getScriptReader()
            while ((execSql = readStatement(br)) != null) {
                statement.executeUpdate(execSql)
            }
            br.close()
            if (statement != null)
                statement.close()
            con.commit()
        } catch (Exception e) {
            if (con != null)
                con.rollback()
            throw new GradleException(e.getMessage());
        } finally {

            if (dataSource != null)
                dataSource.close()
        }

    }

    private String readStatement(BufferedReader br) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("--")) {
                continue;
            }

            if (!StringUtility.stringHasValue(line)) {
                continue;
            }

            if (line.endsWith(";")) {
                sb.append(' ');
                sb.append(line.substring(0, line.length() - 1));
                break;
            } else {
                sb.append(' ');
                sb.append(line);
            }
        }
        String s = sb.toString().trim();
        return s.length() > 0 ? s : null;
    }


    private BufferedReader getScriptReader() throws GradleException, FileNotFoundException {
        BufferedReader answer;
        if (sqlScript.startsWith("classpath:")) {
            String resource = sqlScript.substring("classpath:".length());
            InputStream is =
                    Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            if (is == null) {
                throw new GradleException("SQL script file does not exist: " + resource);
            }
            answer = new BufferedReader(new InputStreamReader(is));
        } else {
            File file = new File(sqlScript);
            if (!file.exists()) {
                throw new GradleException("SQL script file does not exist");
            }
            answer = new BufferedReader(new FileReader(file));
        }
        return answer;
    }
}
