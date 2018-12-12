#!/bin/bash
APP_NAME=jar
usage() {
    echo "PLEASE INPUT : SH XXX.SH [start|stop|restart|status]"
    exit 1
}
is_exist(){
  pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
  if [ -z "${pid}" ]; then
   return 1
  else
    return 0
  fi
}
start(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} IS ALREADY RUNNING. PID IS ${pid} ."
  else
    echo "${APP_NAME} IS START TO STARTING!"
    nohup java -jar $APP_NAME --spring.config.location=application.properties > /dev/null 2>&1 &
    echo "${APP_NAME} IS RUNNING!"
  fi
}
stop(){
  is_exist
  if [ $? -eq "0" ]; then
    kill -9 $pid
    echo "${APP_NAME} HAS STOP!"
  else
    echo "${APP_NAME} IS NOT RUNNING!"
  fi
}
status(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} IS RUNNING. PID IS ${pid}"
  else
    echo "${APP_NAME} IS NOT RUNNING! "
  fi
}
restart(){
  stop
  start
}
case "$1" in
  "start")
    start
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    ;;
  *)
    usage
    ;;
esac