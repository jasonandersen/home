# Container to run the ext-weather service.

FROM oracle-jdk8

ENV EXTWEATHER_HOME /opt/ext-weather
ARG user=service

# Create the service group and user so we don't have to run it under root
RUN groupadd -g 1000 service && \
    useradd -d "$EXTWEATHER_HOME" -u 1000 -g 1000 -m -s /bin/bash ${user}

# Run as service user 
USER ${user}
COPY target/ext-weather.jar ${EXTWEATHER_HOME}
WORKDIR ${EXTWEATHER_HOME}
ENTRYPOINT java -jar ext-weather.jar
