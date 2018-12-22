### DOCKER 安装

#### DOCKER 找到zookeeper
```java
docker search zookeeper #搜索镜像
docker pull zookeeper # 拉取镜像
docker images #查看镜像
docker run --name zookeeper --restart always -d zookeeper #启动docker
docker ps 查看进程
docker kill pid # 关闭进程
docker start|restart|stop zookeeper # 关闭进程

```
