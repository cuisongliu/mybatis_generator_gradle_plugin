This page lists third party plugins and other tools that have been developed for MyBatis generator.

|Plugin Name |Description |Type|URL|
|------------|:-----------|:---|:--|
|JAXB Annotations |This Plugin enables MyBatis Generator (mbg) to add JAXB annotations to the generated Java Model classes. This plugin provides reasonable flexibility while adding JAXB annotations at both, the class level and field / property level. |plugin |https://github.com/mahiarmody/Mbg-Plugin-Jaxb/releases/tag/v1.0.0|
|Database Function Invoker |This plugin enables incorporating or adding Database Function Invocations (such as the soundex, RawToHex, database encryption functions, etc) to the MyBatis Generator generated SQL Map files (XML mapper files). The invoked database functions could be built-in database functions or user defined database functions. |plugin |https://github.com/mahiarmody/Mbg-Plugin-Db_Function_Invoker/releases/tag/v1.0.0|
|mybatis-generator-gradle-plugin |This plugin is based on mybatis generator maven plugin. This is a Gradle plugin of mybatisGeneratorPlugin(mbg). This plugin has all the features of mybatisGeneratorPlugin(mbg), but the plugin realization of groovy from gradle3.3.|plugin |https://github.com/cuisongliu/mybatis_generator_gradle_plugin

Type should be one of the following:

|Type        |Description                                                         |
|------------|:-------------------------------------------------------------------|
|plugin      |A plugin that can be configured with <plugin/>  and developed according to http://mybatis.github.io/generator/reference/pluggingIn.html|
|extension   |An extension developed according to http://mybatis.github.io/generator/reference/extending.html|
|other       |Anything Else |
