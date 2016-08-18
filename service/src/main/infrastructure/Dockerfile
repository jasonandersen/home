# Servlet container for web services.

FROM oracle-jdk8

ENV EXTWEATHERWS_HOME /opt/ext-weather-ws
ARG user=service

# Create the service group and user so we don't have to run it under root
RUN groupadd -g 1000 service && \
    useradd -d "$EXTWEATHERWS_HOME" -u 1000 -g 1000 -m -s /bin/bash ${user}

# Run as service user 
USER ${user}
COPY ext-weather-ws.jar ${EXTWEATHERWS_HOME}
WORKDIR ${EXTWEATHERWS_HOME}
ENTRYPOINT java -jar ext-weather-ws.jar