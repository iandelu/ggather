@echo off
call mvn clean package
call docker build -t com.mycompany/IW .
call docker rm -f IW
call docker run -d -p 9080:9080 -p 9443:9443 --name IW com.mycompany/IW