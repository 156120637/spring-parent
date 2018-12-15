### spring-parent
#### 前提说明
```java
该项目是我在工作中与学习过程中的总结。仅用于交流学习总结
```
#### 项目结构说明
- spring-parent(父项目)
    - spring-common(工具类)
    - spring-repository(持久层)
    - spring-service(接口、服务层)
    - spring-web(页面)
    
#### 结构详细说明
- spring-common
```java
一些工具类
```
- spring-repository
```java
封装配置好的持久层服务
spring-repository-hive
    hive相关，使用的也是jdbcTemplate
spring-repository-integration-kafka
    封装的kafka，试用工作中一些低版本的kafka(0.8以前的版本)
spring-repository-kafka
    对于kafka 0.9以后的版本都有spring的封装
spring-repository-mongo
    mongo的一些配置，mongoTemplate 
spring-repository-mysql
    mysql封装，druid连接池很好用，对hive，mysql这些效果很显著
spring-repository-redis
    redis的配置，包含主从，sentinel哨兵等
spring-repository-rocketmq
    对mq的一些封装使用方法
spring-repository-sharding-jdbc
    当当开源的分库分表框架
spring-repository-sqlserver
    sqlserver的相关配置
    
```
- spring-service
```java
spring-service-base
    基础服务层
spring-service-业务名称
    每一个业务或者接口对应的服务实现
        
```

- spring-web
```java
script
    经常使用的一些脚本
spring-web-业务名称
    每一个业务对应的页面
```
#### 打包方式
```java
使用maven命令：mvn clean package -Dmaven.test.skip=true -Ptest
```

#### 运行方式
```java
该项目是spring-boot项目，严格遵从spring-boot相关约定
```
#### 部署方式
```java
可以打成tar.gz 也可以打成jar包。打成jar包时可使用script中的脚本配置启动。也可加载外部配置properties文件
```
#### 日志说明
```java
使用logback日志规范打印，相关配置在logback.properties 和logback.xml中自定义
```
#### 联系方式
```java
QQ:156120637
Email:tianjiaqin@dangdang.com
```    