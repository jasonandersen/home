#!/bin/bash 
# 
# This script will build a container from the latest ext-weather code,
# run that container and a service virtualization container to stub out
# any downstream services. Then it will run all the Cucumber tests
# against the service.
# 
# Jason Andersen
# 2016.08.25

# start out in the script's directory
cd "$(dirname "$0")"

# build the ext-weather.jar artifact
echo ""
echo "********** building ext-weather.jar **********"
cd service
mvn clean package -Dmaven.test.skip=true

# build the container
echo ""
echo "********** building ext-weather container **********"
docker build . -t ext-weather:latest

# startup containers required for acceptance tests
echo ""
echo "********** booting up acceptance testing environment **********"
cd ..
docker-compose -f docker-compose-at.yml up -d

# wait for containers to start up
# pretty sure there's a better way to do this
sleep 10s

# execute acceptance tests
echo ""
echo "********** running acceptance tests **********"
cd acceptance-tests
mvn clean verify

# shutdown the containers
echo ""
echo "********** shutting down environment **********"
cd ..
docker-compose -f docker-compose-at.yml stop