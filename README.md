[![Build Status](https://travis-ci.org/cuisongliu/mybatis_generator_gradle_plugin.svg?branch=master)](https://travis-ci.org/cuisongliu/mybatis_generator_gradle_plugin)
[![Dependency Status](https://www.versioneye.com/user/projects/5917bcd1e1638f0051a0a624/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5917bcd1e1638f0051a0a624)
[![license](https://img.shields.io/badge/gradle-3.3-brightgreen.svg)](https://gradle.org)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/mit-license.php)

- [mybatis生成器gradle插件(MBG)](#mbg)
    - [添加mbg插件到你的项目](#add-mbg-to-project)
    - [参数配置](#set-mbg-settings)
    - [运行mbg任务](#run-mbg-task)
 



<h2 id="mbg">mybatis生成器gradle插件(MBG)</h2>

这个插件是基于https://github.com/mybatis/generator maven插件做的.这个gradle插件是mybatis生成插件.
这个插件拥有了mybatisGeneratorPlugin(mbg)的全部功能,这个插件实现在gradle3.3上使用groovy实现.
[English](README_EN.md)

<h3 id="add-mbg-to-project">添加mbg插件到你的项目</h3>
使用在所有Gradle版本的构建脚本片段:


    buildscript {
      repositories {
        maven {
          url "https://plugins.gradle.org/m2/"
        }
      }
      dependencies {
        classpath "com.cuisongliu.plugin:mybatis-generator:0.9.4"
      }
    }

    apply plugin: "com.cuisongliu.plugin.mybatis-generator"
    
为Gradle 2.1中引入的新的，潜在的插件机制构建脚本代码段
    plugins {
      id "com.cuisongliu.plugin.mybatis-generator" version "0.9.4"
    }


<h3 id="set-mbg-settings">参数配置</h3>

    mbg {
      overwrite = false
      consoleable = true
      jdbc{
        driver = "com.mysql.jdbc.Driver"
        url    = "jdbc:mysql://[ip]:[port]/[dbname]?useSSL=false"
        username = "username"
        password = "password"
      }
      xml{
          resourcesProject = "src/main/java"
          mapperPlugin = tk.mybatis.mapper.generator.MapperPlugin.class
          mapperMapper = "com.cuisongliu.springboot.core.mapper.MyMapper"
          mapperPackage= "com.cuisongliu.mapper"
          modelPackage = "com.cuisongliu.entity"
          xmlPackage =   "com.cuisongliu.mapper"
      }
    }
    
如果没有设置，插件试图智能使用默认值.

<table>
    <thead>
    <tr>
        <th colspan="2">属性名</td>
        <th>类型</td>
       	<th>描述</td>
       	<th>默认值</td>
    </tr>
    </thead>
	<tbody>
	<tr>
		<td colspan="2"><code>overwrite</code></td>
		<td><code>boolean</code></td>
		<td>是否覆盖已经生成的xml或者代码 </td>
		<td><code>true</code></td>
	</tr>
	<tr>
        <td colspan="2"><code>generatorFile</code></td>
        <td><code>String</code></td>
        <td>mbg的配置文件位置</td>
        <td><code>generatorConfig.xml</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>sqlScript</code></td>
        <td><code>String</code></td>
        <td>要在生成代码之前运行的 SQL 脚本文件的位置.</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>consoleable</code></td>
        <td><code>boolean</code></td>
        <td>如果指定该参数，执行过程会输出到控制台。</td>
        <td><code>false</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>skip</code></td>
        <td><code>boolean</code></td>
        <td>是否跳过生成代码的mbg的任务</td>
        <td><code>false</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>contexts</code></td>
        <td><code>String</code></td>
        <td>如果指定了该参数，逗号隔开的这些context会被执行。</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>tableNames</code></td>
        <td><code>String</code></td>
        <td>如果指定了该参数，逗号隔开的这个表会被运行。</td>
        <td><code>null</code></td>
    </tr>
</tbody></table>
<table>
    <thead>
    <tr>
        <th colspan="2">属性名</td>
        <th>类型</td>
       	<th>描述</td>
       	<th>默认值</td>
    </tr>
    </thead>
    <tbody>
	<tr>
		<td rowspan="4"><code>jdbc</code></td>
		<td><code>driver</code></td>
		<td><code>String</code></td>
		<td>jdbc的驱动类.<em><strong>不能为空</td>
		<td><code>null</code></td>
	</tr>
	<tr>
		<td><code>url</code></td>
		<td><code>String</code></td>
		<td>jdbc的数据库url.<em><strong>不能为空</td>
		<td><code>null</code></td>
	</tr>
	<tr>
        <td><code>username</code></td>
        <td><code>String</code></td>
        <td>jdbc的数据库用户名.<em><strong>不能为空</td>
        <td><code>root</code></td>
    </tr>
    <tr>
        <td><code>password</code></td>
        <td><code>String</code></td>
        <td>jdbc的数据库密码.<em><strong>不能为空</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td rowspan="7"><code>xml</code></td>
        <td><code>javaProject</code></td>
        <td><code>String</code></td>
        <td>生成java文件所在的目录.</td>
        <td><code>src/main/java</code></td>
    </tr>
    <tr>
        <td><code>resourcesProject</code></td>
        <td><code>String</code></td>
        <td>生成xml配置文件mapper所在的目录.</td>
        <td><code>src/main/resources</code></td>
    </tr>
    <tr>
        <td><code>mapperPackage</code></td>
        <td><code>String</code></td>
        <td>mapper配置,生成的Mapper(dao)所在的包所在的位置.<em><strong>不能为空</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td><code>modelPackage</code></td>
        <td><code>String</code></td>
        <td>model配置,生成的实体类所在的包所在的位置.<em><strong>不能为空</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td><code>xmlPackage</code></td>
        <td><code>String</code></td>
        <td>mapper的xml配置,生成的mapper的xml所在的包的位置.<em><strong>不能为空</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td><code>mapperPlugin</code></td>
        <td><code>Class<? extends PluginAdapter></code></td>
        <td>插件信息,xml中插件的类名.<em><strong>不能为空</td>
        <td>
            <code>tk.mybatis.mapper.</code>
            <code>generator.MapperPlugin.</code>
            <code>class</code>
        </td>
    </tr>
    <tr>
        <td><code>mapperMapper</code></td>
        <td><code>String</code></td>
        <td>mapper配置,生成的Mapper方法的父类.<em><strong>不能为空</td>
        <td>
            <code>tk.mybatis.mapper.</code>
            <code>common.Mapper</code>
        </td>
    </tr>
</tbody></table>

<h3 id="run-mbg-task">运行mbg任务</h3>

1. 加入generatorConfig.xml到你的执行模块中去
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   
   <!DOCTYPE generatorConfiguration
     PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
     "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
   
   <generatorConfiguration>
   	<!-- mybatis-generator:generate -->
   	<!--targetRuntime="MyBatis3"-->
   	<context id="MysqlTables" targetRuntime="tk.mybatis.mapper.generator.TkMyBatis3Impl">
   
   		<!-- 生成的Java文件的编码 -->
   	    <property name="javaFileEncoding" value="UTF-8"/>
   	    <!-- 格式化java代码-->
   	    <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter"/> 
   	    <!-- 格式化XML代码 -->
   	    <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter"/>
   		<plugin type="${xml.mapperPlugin}">
               <property name="mappers" value="${xml.mapperMapper}"/>
   			<!-- caseSensitive默认false，当数据库表名区分大小写时，可以将该属性设置为true -->
   			<property name="caseSensitive" value="true"/>
           </plugin>
   		<!-- 去掉生成出来的代码的注解 -->
   		<commentGenerator>
   			<property name="suppressAllComments" value="true" />
   			<property name="suppressDate" value="true" />
   		</commentGenerator>
   		<jdbcConnection driverClass="${jdbc.driver}"
   			connectionURL="${jdbc.url}"
   			userId="${jdbc.username}"
   			password="${jdbc.password}" />
   		
   		<javaTypeResolver>
   			<property name="forceBigDecimals" value="true" />
   		</javaTypeResolver>
   		
   		<javaModelGenerator targetPackage="${xml.modelPackage}"
   			targetProject="${xml.javaProject}">
   			<property name="enableSubPackages" value="true" />
   			<property name="trimStrings" value="true" />
   		</javaModelGenerator>
   
   		<sqlMapGenerator 
   			targetPackage="${xml.xmlPackage}"
   			targetProject="${xml.resourcesProject}" >
   			<property name="enableSubPackages" value="false" />
   		</sqlMapGenerator>
   		
   		<javaClientGenerator 
   			targetPackage="${xml.mapperPackage}"
   			targetProject="${xml.javaProject}"
   			type="XMLMAPPER" >
   		
   		</javaClientGenerator>
   		<!-- 这里设置表的相关信息 -->
   		<table tableName="m_phone_log" domainObjectName="PhoneLog1" mapperName="{0}Dao"
   			enableCountByExample="false" enableUpdateByExample="false"
   			enableDeleteByExample="false" enableSelectByExample="false" modelType="flat">
   			<property name="useActualColumnNames" value="false" />
   			<generatedKey column="" sqlStatement="MySql" identity="true"/>
   			<!--<generatedKey column="ID"-->
   				<!--sqlStatement="SELECT LAST_INSERT_ID()" />-->
   		</table>
   	</context>
   
   </generatorConfiguration>
   ```
   设置table信息中的变量即可,文件中.
   
2. 在build.gradle中加入[参数配置](#set-mbg-settings)
3. 在build.gradle所在目录执行 ```gradle mbg ```
4. 默认支持mysql,若使用oracle或者其他的数据库需要额外增加如下配置
    ```
        buildscript{
            def baseUrl = "http://maven.cuisongliu.com"
            def nexusUrl = "$baseUrl/content/groups/public/"
            repositories {
                mavenLocal()
                maven { url "$nexusUrl" }
            }
            dependencies {
                classpath "com.oracle:ojdbc6:11.1.0.7.0"
            }
        }
    ```
    在使用插件之前加入buildscript,配置classpath的driver依赖jar包(这里的maven地址根据情况修改)
