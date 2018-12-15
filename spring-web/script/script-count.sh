host_list="
机器列表
"

for i in $host_list
do
echo -e "==========$i=========="
echo "$i count:" >>./log.log
ssh -o StrictHostKeyChecking=no root@$i "cd /var/www/logs/;grep -o '统计的字符' file-name |wc -l" >> ./log.log
sleep 3
done