hosts="
机器IP
"

for i in $hosts
do

rsync -e "ssh -o StrictHostKeyChecking=no" -av /var/www/ root@$i:/var/www/
ssh -o StrictHostKeyChecking=no root@$i 'cd /var/www/xxx/;sh server.sh restart'

done
