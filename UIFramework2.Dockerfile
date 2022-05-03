FROM maven:3.6.0-jdk-11-slim

RUN dpkg --add-architecture amd64
RUN dpkg --print-architecture

RUN apt-get update \
	&& apt-get install -y --no-install-recommends \
	gnupg2 \
    wget \
    libcurl3 \
    xdg-utils \
    fonts-liberation

#RUN useradd apps
#RUN mkdir -p /home/apps && chown apps:apps /home/apps

#RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
#RUN apt install -y ./google-chrome-stable_current_amd64.deb
#RUN apt-get install -y chromium-driver

RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add \
  && echo 'deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main' | tee /etc/apt/sources.list.d/google-chrome.list \
  && apt-get update -qq \
  && apt-get install -y google-chrome-stable libnss3 libgconf-2-4

RUN CHROMEDRIVER_VERSION=`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE` \
  && curl -sS -o /tmp/chromedriver_linux64.zip http://chromedriver.storage.googleapis.com/101.0.4951.41/chromedriver_linux64.zip \
  && unzip /tmp/chromedriver_linux64.zip \
  && mv chromedriver /usr/bin/

RUN useradd -ms /bin/bash clipuser
USER clipuser
WORKDIR /home/clipuser/framework
COPY pom.xml /home/clipuser/framework
COPY /src /home/clipuser/framework/src

RUN java --version
RUN mvn --version
RUN google-chrome --version
