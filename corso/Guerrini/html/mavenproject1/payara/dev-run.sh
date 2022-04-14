#!/bin/bash -e

# Runs a development environment on a local docker-engine or any OCI compliant engine
# Also attaches volume mounts to ./liberty and ./target folder.

# Please change this value to your server.version in pom.xml
SERVER_VERSION=$(cat pom.xml | grep 'server.version>' | cut -d '<' -f 2 | cut -d '>' -f 2)
JDK_VERSION=jdk$(cat pom.xml | grep 'java.version>' | cut -d '<' -f 2 | cut -d '>' -f 2)
WAR_NAME=$(cat pom.xml | grep 'artifactId>' -m1 | cut -d '<' -f 2 | cut -d '>' -f 2)
CONTAINER_NAME=development-payara-full-${JDK_VERSION}

echo "Server version: ${SERVER_VERSION}"
echo "JDK version (extracted from pom.xml): ${JDK_VERSION}"
echo "WAR name (extracted from pom.xml): ${WAR_NAME}"

echo "--> Starting WAD (Watch and Deploy)..."
trap 'kill $WADPID; exit' INT
java -jar wad.jar "$(pwd)"/.wad-dropins/ &
WADPID=$!

echo "--> Running payara dev-environment v${SERVER_VERSION} using ${JDK_VERSION} on docker"
docker run --rm \
    -p 8080:8080 -p 8181:8181 -p 4848:4848 -p 9009:9009 -p 5005:5005 \
    -v "$(pwd)"/payara/lib/:/opt/payara/appserver/glassfish/domains/production/lib/ \
    -v "$(pwd)"/payara/asadmin-postboot:/opt/payara/config/post-boot-commands.asadmin \
    -v "$(pwd)"/payara/asadmin-preboot:/opt/payara/config/pre-boot-commands.asadmin \
    -v "$(pwd)"/.wad-dropins/:/opt/payara/appserver/glassfish/domains/production/autodeploy/ \
    --env-file="$(pwd)"/.env-file \
    --name ${CONTAINER_NAME} \
    hassenasse/payara:${SERVER_VERSION}-${JDK_VERSION}
