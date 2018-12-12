#!/bin/bash
cd `dirname $0`
if [ "$1" = "start" ]; then
    ./start.sh
else
    if [ "$1" = "stop" ]; then
        ./stop.sh $2
    else
        if [ "$1" = "debug" ]; then
            ./start.sh debug
        else
            if [ "$1" = "restart" ]; then
                ./restart.sh
            else
                if [ "$1" = "dump" ]; then
                    ./dump.sh
                else
                    if [ "$1" = "jmx" ]; then
                        ./start.sh jmx
                        else
                            if [ "$1" = "console" ]; then
                                ./console.sh
                                else
                                    if [ "$1" = "chgmod" ]; then
                                    ./chgmod.sh
                                    else
                                        echo "ERROR: Please input argument: start or stop or debug or restart or dump or jmx or console or chgmod."
                                        exit 1
                            fi
                        fi
                    fi
                fi
            fi
        fi
    fi
fi
