#!/bin/bash

#turn on debug mode
set -x

#move to server dir
SCRIPT_DIR=$(dirname $0)
cd $SCRIPT_DIR/ondetem-server

#run server
./gradlew run
