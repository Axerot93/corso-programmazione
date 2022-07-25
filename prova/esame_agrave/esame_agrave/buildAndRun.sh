#!/bin/sh
mvn clean package && docker build -t tss/esamedelima .
docker rm -f esamedelima || true && docker run -d -p 8080:8080 -p 4848:4848 --name esamedelima tss/esamedelima 
