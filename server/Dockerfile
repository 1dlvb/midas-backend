FROM maven:3.9.5-openjdk-11-slim
LABEL maintainer="matushkin-2017@mail.ru"
VOLUME /tmp
EXPOSE 8099
ARG JAR_FILE=target/server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} server.jar
ENTRYPOINT ["java", "-jar", "/server.jar"]