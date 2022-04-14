#!/bin/sh
mvn clean package && docker build -t it.tss/world .
docker rm -f world || true && docker run -d -p 8080:8080 -p 4848:4848 --name world it.tss/world 
