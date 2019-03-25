### 团队协作工具

#### 说明

```java
在日常开发的过程中，各个接口的文档是相当必要的，如何能在项目开发中将文档很好的保存，给使用者提供一个满意的说明，在团队合作中显得尤为重要。在公司里经常使用的就是twiki，MediaWiki，teambition等等。对于开发人员来说，并不需要多么炫的功能，只要能给一个编译文本就够了。
```

#### twiki介绍

 - [官方网站](http://twiki.org/)
 - [官方文档使用方法](https://twiki.org/cgi-bin/view/TWiki06x01/WelcomeGuest)

```java
TWiki是一个开源（GPL）的wiki程序。软件定位为“灵活、强大、易于使用的企业协作平台”，运行于Perl环境。拥有编程技能的人可以使用变量创建动态页面，譬如内容表格，或者嵌入式搜索结果的页面。默认内置所见即所得编辑器，完善的用户权限系统，不需要任何数据库，完全基于文件目录的格式化引擎。twiki部署起来是有点复杂的。
```

 - 环境准备

   ```java
   $ sudo apt-get install apache2 perl cron grep rcs patch php5
   $ sudo apt-get install libapache2-mod-php5 libcgi-session-perl libdigest-sha1-perl libhtml-parser-perl
   ```

   

 - 下载twiki包

   ```java
   $ wget http://downloads.sourceforge.net/project/twiki/TWiki%20for%20all%20Platforms/TWiki-5.0.1/TWiki-5.0.1.tgz?r=&ts=1293085896&use_mirror=nchc
   $ sudo tar -xvzf TWiki-5.0.1.tgz
   $ sudo cp -a twiki /var/www/
   $ sudo chown -R www-data:www-data /var/www/twiki
   ```

- 修改配置

  ```java
  $ sudo cp /var/www/twiki/bin/LocalLib.cfg.txt /var/www/twiki/bin/LocalLib.cfg
  修改LocalLib.cfg中的$twikiLibPath为：
  	$twikiLibPath = "/var/www/twiki/lib"
  
  生成twiki.conf文件：http://twiki.org/cgi-bin/view/TWiki/ApacheConfigGenerator，并复制到/var/www/twiki/twiki.conf
  修改/etc/apache2/httpd.conf，加入一行：
  	include "/var/www/twiki/twiki.conf"    
  修改twiki.conf文件中的
  <FilesMatch "^(configure)$"> 节点，设置允许访问configure页面的来路IP或者用户名。
  	Allow from 127.0.0.1 192.168.1.100
  	Require user tianjiaqin
  重启apache2
  	$ sudo /etc/init.d/apache2 restart
  访问：http://<ipaddress>/twiki/bin/configure 可进入配置页面，配置完成后进入主页。
  中文支持
  	TWiki默认是iso8859-1编码，不支持中文编辑， 界面也是全英文。让TWiki支持中文，首先，确保服务器的locale安装有zh_CN.UTF-8。
  	$ sudo locale-gen zh_CN
  	$ sudo locale-gen zh_CN.UTF-8
  	$ sudo dpkg-reconfigure locales
  ```

  

