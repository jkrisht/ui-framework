# Execute below command to build an image with the dependencies
# DOCKER_BUILDKIT=0 docker build -f UIFramework.Dockerfile -t clipboardautoimage:latest .

# Execute below command to run spin up the container with the built image
# docker run -d --privileged --name myc2 clipboardautoimage tail -f /dev/null

# Execute below command to enter into docker console
# docker exec -it myc2 bash

# Execute below command to run the tests
# mvn clean test

FROM amd64/ubuntu:maven:3.6.0-jdk-11-slim

ARG CHROME_VERSION=101.0.4951.41

# Install apt-get, curl and openjdk-11
RUN apt-get install
RUN apt-get update
RUN apt-get install -y wget software-properties-common
RUN add-apt-repository ppa:openjdk-r/ppa
RUN apt-get install -y openjdk-11-jdk maven

## Installing Chrome.
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt install xdg-utils -y
RUN dpkg -i --force-depends google-chrome-stable_current_amd64.deb
RUN apt-get install -f -y

RUN java --version
RUN mvn --version
RUN google-chrome --version

ENV QEMU_STRACE=1

WORKDIR /home/framework
COPY src /home/framework/src
COPY pom.xml /home/framework

RUN mvn -f /home/framework/pom.xml clean
