### Linux常用命令
```powershell
linux 实时命令调优常用的命令
```
```powershell
top |top -c |top –H -p
    可以查看内存，负载，内存，以及进程相关信息
    查看详细信息
    查看运行较长的java进程
    Shift+P 可以对处理器占用率进行排序
netstat |netstat -tunlp
    网络使用情况
    查看端口信息
scp -r 文件  root@host:/路径
    同步文件命令
    -r  递归复制整个目录
        
jps | jps -l
    java命令，查看java进程信息，详细信息
jstack
    java命令，查看java程序堆栈情况
iostat
    查看io相关情况
vmstat 5
    5秒刷新一次
    CPU使用情况    
rsync -avP 文件路径 root@host:/路径
    同步文件 文件夹
ssh -o StrictHostKeyChecking=no 
    忽略认证，可以在脚本中直接连接执行命令，不必输入确认
grep '字符' $ file
    查看字符在file中的次数
            
    
```
```powershell
命令和管道的使用
less file |grep '' 过滤指定的文件
建立软链接
ln -fs target_dir base_dir
    建立软链接


```
