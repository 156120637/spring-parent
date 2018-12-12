#!/bin/bash
cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
chmod -R 755 $DEPLOY_DIR;
find $DEPLOY_DIR -name "*.properties" -type f -exec chmod 644 {} \;
chmod 600 $DEPLOY_DIR/bin/properties/jmx_config/jmxremote.password;
