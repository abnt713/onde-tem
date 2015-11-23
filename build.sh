#!/bin/bash

#turn on debug mode
set -x

#move to directory where the script is runned
SCRIPT_DIR=$(dirname $0)
cd $SCRIPT_DIR

#build client
cd ondetem-client
ember build

#build server
cd ..
cd ondetem-server
./gradlew build

#remove client files on server dir
rm -rf ./public

#copy generated client files to server
cp -r ../ondetem-client/dist ./public

#recreate '.gitkeep' file on public dir
touch ./public/.gitkeep
