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
package com.cuisongliu.plugin.generator.mybatis.extension

import org.mybatis.generator.api.PluginAdapter

/**
 * <p>ProjectName: gradle-plugin</p>
 * <p>Package: com.cuisongliu.plugin.generator.mybatis.extension</p>
 * <p>ClassName: MybatisGeneratorJdbcExtension.groovy</p>
 * <p>Description: gradle mybatis generator plugin xml需要的配置参数</p>
 * <p>Copyright (c) 2017 cuisongliu@qq.com</p>
 * @author cuisongliu
 * @version 1.0 创建时间：2017年5月10日 20:06:20
 */
class MybatisGeneratorXmlExtension {
    /**
     * 生成java文件所在的目录<br>
     * 默认为 src/main/java
     */
    String javaProject = "src/main/java"

    /**
     * 生成xml配置文件mapper所在的目录<br>
     * 默认为 src/main/resources
     */
    String resourcesProject = "src/main/resources"

    /**
     * mapper配置,生成的Mapper(dao)所在的包所在的位置<br/>
     * 默认值为null 需要设置,否则会报错
     */
    String mapperPackage = null

    /**
     * model配置,生成的实体类所在的包所在的位置<br/>
     * 默认值为null 需要设置,否则会报错
     */
    String modelPackage = null

    /**
     * mapper的xml配置,生成的mapper的xml所在的包的位置<br/>
     * 默认值为null 需要设置,否则会报错
     */
    String xmlPackage = null


    /**
     * 插件信息,xml中插件的类名,继承自<code>org.mybatis.generator.api.PluginAdapter</code><br/>
     * 默认值为tk.mybatis.mapper.generator.MapperPlugin.class
     */
    Class<? extends PluginAdapter> mapperPlugin = tk.mybatis.mapper.generator.MapperPlugin.class

    /**
     * mapper配置,生成的Mapper类的父类<br/>
     * 默认值为tk.mybatis.mapper.common.Mapper
     */
    String mapperMapper = "tk.mybatis.mapper.common.Mapper"

}
