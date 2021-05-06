#!/bin/sh
mvn clean package && docker build -t com.mycompany/IW .
docker rm -f IW || true && docker run -d -p 9080:9080 -p 9443:9443 --name IW com.mycompany/IW