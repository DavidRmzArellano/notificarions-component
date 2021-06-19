#!/bin/bash
echo $PWD
echo "****************"
echo "* Building jar! "
echo "****************"
A=${PWD##*/}
PROJ=/Users/sheen/Documents/Residencia/backend/jenkins/jenkins_home/workspace/
ROUTE="$PROJ$A"
docker run --rm -v /Users/sheen/Documents/Residencia/backend/jenkins/root/.m2:/root/.m2 -v $ROUTE:/app -w /app maven:adoptopenjdk "$@"
echo $ROUTE
