#!/bin/bash
# 环境变量处理，解决 jinkens 读取不到环境变量的问题
# 系统级环境变量
if [ -f "/etc/profile" ]; then
        . /etc/profile
fi

# 用户级环境变量
bash_profile="$HOME/.bash_profile"
profile="$HOME/.profile"

exe_file=""

if [ -f "$profile" ]; then
	exe_file=". $profile"
elif [ -f "$bash_profile" ]; then
	exe_file=". $bash_profile"
fi

$exe_file

set -e
# 环境变量处理完毕

path=$(cd "$(dirname "$0")" ; cd ../; pwd)
war_path=$(cd "$(dirname "$0")" ; pwd)
service=`echo "$war_path" | awk -F "/" '{print $(NF)}'`

echo "update version path=$path , service=$service"

# set backup path
backup="$path/backup"
if [ ! -d "$path/backup" ];then
        echo "$path/backup not exists create it .." 
        mkdir $path/backup
fi

# get cur_time
cur_time=$(date +%F-%H-%M-%S)

# check service run status
running_count=`ps -ef | grep "$path/" | grep -v "grep" | wc -l`

echo "tomcat:$path running_acount=$running_count"
if [ $running_count -gt 0 ]; then
    echo "service($service) already running, try kill it."
    echo "stop tomcat service : $path"
    ps -ef | grep java | grep $path/ | awk  '{print $2}' | xargs kill -9
fi

# webapps backup
if [ -d "$path/webapps/$service" ];then 
	echo "backup $path/webapps/$service to $backup/$service.$cur_time"
	mv $path/webapps/$service/ $backup/$service.$cur_time
fi

#delete work
rm -rf $path/work/

mkdir -p $path/webapps/$service

# unzip war
unzip $path/$service/$service.war -d  $path/webapps/$service

#start the tomcat serice
cd $path
./bin/startup.sh start

