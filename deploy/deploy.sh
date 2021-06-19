
#!/bin/bash

docker run -ti -d --network provider-red --ip 172.16.1.5 -p8087:8087 --name sending-notifications sending-notifications:latest
