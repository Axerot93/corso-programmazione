#!/bin/sh
mvn clean package && docker build -t it.tss/bkmapp .
docker rm -f bkmapp || true && docker run -d -p 8080:8080 -p 4848:4848 --name bkmapp it.tss/bkmapp 
