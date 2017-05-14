[![Build Status](https://travis-ci.org/iamthechad/javadoc2dash.svg)](https://travis-ci.org/cuisongliu/gradle-plugins)
[![Dependency Status](https://www.versioneye.com/user/projects/5913d942a786140061505272/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5913d942a786140061505272)
[![license](https://img.shields.io/badge/gradle-3.3-brightgreen.svg)](https://gradle.org)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/mit-license.php)

- [MyBatis Generator Gradle Plugin(MBG)](#mbg)
    - [Add the plugin to you project](#add-mbg-to-project)
    - [Specify settings](#set-mbg-settings)
    - [Run the mbg task](#run-mbg-task)
 


<h1 id="gradle-plugin">Gradle plugin</h1>
 
This project is some gradle plugin collections.So far there are [mbg](#mbg) plugins,etc.
[简体中文](README.md)
<h2 id="mbg">MyBatis Generator Gradle Plugin(MBG)</h2>
This plugin is based on https://github.com/mybatis/generator. This is a gradle plugin of mybatisGeneratorPlugin(mbg). This plugin has all the features of mybatisGeneratorPlugin(mbg), but the plugin realization of groovy from gradle3.3.

<h3 id="add-mbg-to-project">Add the plugin to you project</h3>
Build script snippet for use in all Gradle versions:


    buildscript {
      repositories {
        maven {
          url "https://plugins.gradle.org/m2/"
        }
      }
      dependencies {
        classpath "com.cuisongliu.plugin:mybatis-generator:1.0"
      }
    }

    apply plugin: "com.cuisongliu.plugin.mybatis-generator"
    
Build script snippet for new, incubating, plugin mechanism introduced in Gradle 2.1:

    plugins {
      id "com.cuisongliu.plugin.mybatis-generator" version "1.0"
    }


<h3 id="set-mbg-settings">Specify settings</h3>

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
    
If no settings are provided, the plugin tries to use sensible defaults.

<table>
    <thead>
    <tr>
        <th colspan="2">Setting Name</td>
        <th>Type</td>
       	<th>Description</td>
       	<th>Default</td>
    </tr>
    </thead>
	<tbody>
	<tr>
		<td colspan="2"><code>overwrite</code></td>
		<td><code>boolean</code></td>
		<td>Specifies whether the mojo overwrites existing files. Default is true. </td>
		<td><code>true</code></td>
	</tr>
	<tr>
        <td colspan="2"><code>generatorFile</code></td>
        <td><code>String</code></td>
        <td>Location of the configuration file.</td>
        <td><code>generatorConfig.xml</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>sqlScript</code></td>
        <td><code>String</code></td>
        <td>Location of a SQL script file to run before generating code.</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>consoleable</code></td>
        <td><code>boolean</code></td>
        <td>Specifies whether  progress messages to the console.</td>
        <td><code>false</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>skip</code></td>
        <td><code>boolean</code></td>
        <td>Skip generator.</td>
        <td><code>false</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>contexts</code></td>
        <td><code>String</code></td>
        <td>Comma delimited list of contexts to generate.</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td colspan="2"><code>tableNames</code></td>
        <td><code>String</code></td>
        <td>Comma delimited list of table names to generate.</td>
        <td><code>null</code></td>
    </tr>
    </tbody></table>
    <table>
        <thead>
        <tr>
            <th colspan="2">Setting Name</td>
            <th>Type</td>
            <th>Description</td>
            <th>Default</td>
        </tr>
    </thead>
    <tbody>
	<tr>
		<td rowspan="4"><code>jdbc</code></td>
		<td><code>driver</code></td>
		<td><code>String</code></td>
		<td>JDBC Driver name.<em><strong>Not Null</td>
		<td><code>null</code></td>
	</tr>
	<tr>
		<td><code>url</code></td>
		<td><code>String</code></td>
		<td>JDBC URL.<em><strong>Not Null</td>
		<td><code>null</code></td>
	</tr>
	<tr>
        <td><code>username</code></td>
        <td><code>String</code></td>
        <td>JDBC user name.<em><strong>Not Null</td>
        <td><code>root</code></td>
    </tr>
    <tr>
        <td><code>password</code></td>
        <td><code>String</code></td>
        <td>JDBC password.<em><strong>Not Null</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td rowspan="7"><code>xml</code></td>
        <td><code>javaProject</code></td>
        <td><code>String</code></td>
        <td>Mybatis generator output sources  directory.</td>
        <td><code>src/main/java</code></td>
    </tr>
    <tr>
        <td><code>resourcesProject</code></td>
        <td><code>String</code></td>
        <td>Mybatis generator output resources  directory.</td>
        <td><code>src/main/resources</code></td>
    </tr>
    <tr>
        <td><code>mapperPackage</code></td>
        <td><code>String</code></td>
        <td>Mybatis generator output javaClient package.<em><strong>Not Null</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td><code>modelPackage</code></td>
        <td><code>String</code></td>
        <td>Mybatis generator output javaModel  package.<em><strong>Not Null</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td><code>xmlPackage</code></td>
        <td><code>String</code></td>
        <td>Mybatis generator output  sqlMapper  package.<em><strong>Not Null</td>
        <td><code>null</code></td>
    </tr>
    <tr>
        <td><code>mapperPlugin</code></td>
        <td><code>Class<? extends PluginAdapter></code></td>
        <td>Mybatis generator plugin class.<em><strong>Not Null</td>
        <td>
            <code>tk.mybatis.mapper.
            generator.MapperPlugin.
            class</code>
        </td>
    </tr>
    <tr>
        <td><code>mapperMapper</code></td>
        <td><code>String</code></td>
        <td>Mybatis generator javaClient  extends class.<em><strong>Not Null</td>
        <td>
            <code>tk.mybatis.mapper.
            common.Mapper</code>
        </td>
    </tr>
</tbody></table>

<h3 id="run-mbg-task">Run the mbg task</h3>
1. Add generatorConfig.xml to your execution module.
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   
   <!DOCTYPE generatorConfiguration
     PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
     "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
   
   <generatorConfiguration>
   	<!-- mybatis-generator:generate -->
   	<!--targetRuntime="MyBatis3"-->
   	<context id="MysqlTables" targetRuntime="tk.mybatis.mapper.generator.TkMyBatis3Impl">
   
   		<!-- generator java file encoding -->
   	    <property name="javaFileEncoding" value="UTF-8"/>
   	    <!-- format java code-->
   	    <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter"/> 
   	    <!-- format XML files -->
   	    <property name="xmlFormatter" value="org.mybatis.generator.api.dom.DefaultXmlFormatter"/>
   		<plugin type="${xml.mapperPlugin}">
               <property name="mappers" value="${xml.mapperMapper}"/>
   			<!-- caseSensitive default false，When the database table name is case sensitive，you can set this property to true -->
   			<property name="caseSensitive" value="true"/>
           </plugin>
   		<!-- delete generator  notes-->
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
   		<!-- set table info -->
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
   Set the variable in the table information.
   
2. In the build.gradle file append [Specify settings](#set-mbg-settings)
3. In the build.gradle directory execute ```gradle mbg ```
4. The default support for mysql.If you use oracle or other database need to add the following additional configuration to [Specify settings](#set-mbg-settings).
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
    Add buildscript before using the plugin，configure the classpath driver depends on the jar package (where the maven address changes as the case may be)
