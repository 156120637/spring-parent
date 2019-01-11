### Arthas 相关使用

#### 相关链接

[下载地址](http://search.maven.org/classic/#search%7Cga%7C1%7Cg%3A%22com.taobao.arthas%22%20AND%20a%3A%22arthas-packaging%22)

[文档地址 bin-zip](https://alibaba.github.io/arthas/)

#### Arthas监控

```shell
解压： unzip 包名
安装： install-local.sh
运行： sh as.sh
退出： quit|exit
关闭： shutdown
attach 目标进程
reset： 重置增强类
cls 
help
删除卸载：rm -rf ~/.arthas/ ~/.arthas_history
```

#### 查看命令

```shell
搜索类信息： sc class-pattern method-pattern 
搜索方法信息： sm class-pattern method-pattern 
```

#### 监测命令

- 监控响应时间(>> 将结果写道文件中)

  ```shell
  trace class-pattern method-pattern > result-file
  trace class-pattern method-pattern condition-express
  trace com.dangdang.* 方法名 > log.log
  ```

- 方法执行监控

  ```java
  monitor class-pattern method-pattern 非实时
  ```

- 基础监控

  ```java
  监测面板：dashboard	
  jvm： jvm
  
  ```

- 方法执行参数

  ```java
  watch com.dangdang.* 方法名 "{params.length, returnObj.data.trades[0]}" returnObj.data.trades.size()>0 -x 2 -n 1
  
  ```

- 查看线程CPU占比

  ```shell
  thread -n 3 进程前3 
  ```

- 检测方法调用次数

  ```shell
  monitor -c 5 com.dangdang.* 方法名  //-c 统计周期5秒，默认120秒
  ```

- 检查方法入参和出参

  ```shell
  //同时检测方法调用前后的入参和返回值
  watch com.dangdang.* 方法名 "params,reurnObj" -x 1 -b -s
  
  ```

- 检查记录方法所有执行情况(总响应时间)

  ```shel
  tt -t -n 20 com.dangdang.* 方法名
  如果方法有重载
  tt -t -n 20 com.dangdang.* 方法名 “params.length==1”  // 指定参数个数
  ```

#### 修改options配置

```java
options 
	save-result true 开启日志保存功能
	job-timeout 1d 后台工作时间

jobs 查看job信息
kill job-id 关掉job
```

#### 输出日志

```java
输出路径为： ~/logs/arthas-cache/{pid}/{job-id}
trace class-pattern method-pattern condition-express >> & 
输出路径为:  ~/logs/arthas-cache/test.out
trace class-pattern method-pattern condition-express >> test.out & 
```

#### 在工作中我最常使用的

```java
thread -n 进程数
    想要查看的进程数量
    

将包下的方法名执行情况打印到result.log中
    trace class-pattern method-pattern > result.log

jobs 
    查看后台进程

jobs options
    查看jobs相关设置，最常使用的是时间  30d
    可以使用 jobs options 参数  就设置了。

dashboard
    查看jvm的先关使用情况，包含回收情况等
    
记住输出路径
    ~/logs/arthas-cache/{pid}/{job-id} 不是当前目录    

```

