#!/bin/bash
cd `dirname $0`
source start_base
#make sure classpath .. is ahead of the lib path
nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS -classpath $CONF_DIR:$LIB_JARS:$APP_LIB_JARS:. $CONTAINER_MAIN > /dev/null 2>&1 &
echo "Please check the log file in $LOGS_DIR."
