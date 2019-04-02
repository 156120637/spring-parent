### spring-parent
#### 前提说明
```java
该项目是我在工作与学习过程中的学习与总结。仅用于交流学习.
master都是使用conf进行配置的，可能在使用的过程会不是很方便，因为有时候指向引入一些model，并不想引入一些配置，所以使用xml进行配置还是有很大好处的。等有时间我会在分支上增加一版使用xml进行配置的版本。
```
#### 项目结构说明
- spring-parent(父项目)
    - spring-common
    - spring-repository
    - spring-service
    - spring-web
    
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
    mysql封装，可以使用下面的sharding-jdbc代替
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
    基础服务层(存放枚举，公用键值等)
spring-service-biz
    每一个接口对应的服务实现
spring-service-job
    elastic-job 定时作业
spring-service-listener
    一些消息监听作业（kafka，rocketmq,rabbitmq等）            
```

- spring-web
```java
script
    经常使用的一些脚本
spring-web-manager
    相关管理界面
spring-web-api
    对外抛出的接口  
spring-web-plan
    个人计划存放位置    
spring-web-tools
    一些工作中能用到的工具介绍和一些学习的总结   
    
```
#### 打包方式
```java
使用maven命令：mvn clean package -Dmaven.test.skip=true -Ptest
```

#### 运行方式
```java
该项目是spring-boot项目，严格遵从spring-boot相关约定。为了测试方便这里都没有删除主类 XXXApplication，在相互引用的时候可能会出现无法注入Bean的问题，只需将引入包的XXXApplication删除即可，这也是springboot自动扫描XXXApplication下包的原因。
```
#### 部署方式
```java
可以打成tar.gz 也可以打成jar包。打成jar包时可使用script中的脚本配置启动。也可加载外部配置properties文件。个人建议打成tar包。tar包的虚拟机配置可以在项目下的  项目名/bin/properties/* 修改 。启动脚本在 /项目名/bin/*
```
#### 日志说明
```java
使用logback日志规范打印，详细配置可以在logback.properties 和logback.xml中自定义
```
#### 联系方式
```java
QQ:156120637
Email:tianjiaqin@dangdang.com
```    