#!/bin/bash
echo $PWD
echo "****************"
echo "* Building jar! "
echo "****************"
A=${PWD##*/}
PROJ=/home/admin/jenkins/jenkins_home/workspace/
ROUTE="$PROJ$A"
docker run --rm -v /root/.m2:/root/.m2 -v $ROUTE:/app -w /app maven:3-alpine "$@"
echo $ROUTE
