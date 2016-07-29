#!/bin/sh
### BEGIN INIT INFO
# Provides:          cluster
# Required-Start:    #local_fs $remote_fs mountall
# Required-Stop:
# Default-Start:     S
# Default-Stop:      0
# Short-Description: Start graphics module and cluster application at boot
# Description:       Starts the graphics module first and then the cluster application
#                    This should be started as soon as possible after boot
### END INIT INFO

modprobe galcore.ko
/home/valid/cluster.sh
