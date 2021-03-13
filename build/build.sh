
#!/bin/bash

# Copia el jar
pwd
cp -f ./target/*.jar ./build/

echo "######################"
echo "*** Building image ***"
echo "######################"

cd build && docker build -t "sending-notifications" .
