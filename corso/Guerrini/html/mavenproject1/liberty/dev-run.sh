#!/bin/bash -e

# Runs a development environment on a local docker-engine or any OCI compliant engine
# Also attaches volume mounts to ./liberty and ./target folder.

# Please change this value to your server.version in pom.xml
SERVER_VERSION=$(cat pom.xml | grep 'server.version>' | cut -d '<' -f 2 | cut -d '>' -f 2)
JDK_VERSION=jdk$(cat pom.xml | grep 'java.version>' | cut -d '<' -f 2 | cut -d '>' -f 2)
WAR_NAME=$(cat pom.xml | grep 'artifactId>' -m1 | cut -d '<' -f 2 | cut -d '>' -f 2)
CONTAINER_NAME=development-openliberty-${JDK_VERSION}

echo "Server version: ${SERVER_VERSION}"
echo "JDK version (extracted from pom.xml): ${JDK_VERSION}"
echo "WAR name (extracted from pom.xml): ${WAR_NAME}"

echo "--> Starting WAD (Watch and Deploy)..."
trap 'kill $WADPID; exit' INT
java -jar wad.jar "$(pwd)"/.wad-dropins/ &
WADPID=$!

echo "--> Running openliberty dev-environment v${SERVER_VERSION} using ${JDK_VERSION} on docker"
docker run --rm \
    -p 9080:9080 -p 9443:9443 -p 5005:5005 \
    -v "$(pwd)"/liberty/server.xml:/opt/liberty/wlp/usr/servers/defaultServer/server.xml \
    -v "$(pwd)"/liberty/server.env:/opt/liberty/wlp/usr/servers/defaultServer/server.env \
    -v "$(pwd)"/liberty/jvm.options:/opt/liberty/wlp/usr/servers/defaultServer/jvm.options \
    -v "$(pwd)"/liberty/bootstrap.properties:/opt/liberty/wlp/usr/servers/defaultServer/bootstrap.properties \
    -v "$(pwd)"/liberty/resources:/opt/liberty/wlp/usr/shared/resources/ \
    -v "$(pwd)"/.wad-dropins/:/opt/liberty/wlp/usr/servers/defaultServer/dropins/ \
    --env-file="$(pwd)"/.env-file \
    --name ${CONTAINER_NAME} \
    hassenasse/openliberty:${SERVER_VERSION}-jdk11