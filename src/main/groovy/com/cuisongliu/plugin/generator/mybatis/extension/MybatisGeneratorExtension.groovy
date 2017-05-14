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
/**
 * <p>ProjectName: gradle-plugin</p>
 * <p>Package: com.cuisongliu.plugin.generator.mybatis.extension</p>
 * <p>ClassName: MybatisGeneratorExtension.groovy</p>
 * <p>Description: gradle mybatis generator plugin 公共配置参数</p>
 * <p>Copyright (c) 2017 cuisongliu@qq.com</p>
 * @author cuisongliu
 * @version 1.0 创建时间：2017年5月10日 20:06:20
 */
class MybatisGeneratorExtension {

    /**
     * 是否覆盖已经生成的xml或者代码<br>
     * 如果指定了该参数，如果生成的java文件存在已经同名的文件，新生成的文件会覆盖原有的文件。<br>
     * 默认为 true
     */
    boolean overwrite = true

    /**
     * mbg的配置文件<br>
     * 默认名称为 generatorConfig.xml
     */
    def generatorFile = "generatorConfig.xml"

    /**
     * 要在生成代码之前运行的 SQL 脚本文件的位置。 如果空，不会执行任何脚本。<br>
     * 如果不是空，jdbcDriver, jdbcURL 参数必须提供。 另外如果连接数据库需要认证也需要提供 jdbcUserId 和 jdbcPassword 参数。<br>
     * 值可以使一个文件系统的绝对路径或者是一个使用"classpath:"开头放在构建的类路径下的路径。
     */
    String sqlScript = null

    /**
     * 如果指定该参数，执行过程会输出到控制台。<br>
     * 默认为 false
     */
    boolean consoleable = false

    /**
     * 是否跳过生成代码的mbg的任务,若为true则中断任务.<br>
     * 默认值为 false
     */
    boolean skip = false

    /**
     * 如果指定了该参数，逗号隔开的这些context会被执行。<br>
     * 这些指定的context必须和配置文件中 <context> 元素的 id 属性一致。<br>
     * 只有指定的这些contextid会被激活执行。如果没有指定该参数，所有的context都会被激活执行。<br>
     */
    String contexts = null

    /**
     * 如果指定了该参数，逗号隔开的这个表会被运行， 这些表名必须和 <table> 配置中的表面完全一致。<br>
     * 只有指定的这些表会被执行。 如果没有指定该参数，所有的表都会被执行。 按如下方式指定表明:<br>
     * <p>table</p>
     * <p>schema.table</p>
     * <p>catalog..table</p>
     * 等等。
     */
    String tableNames = null
}


