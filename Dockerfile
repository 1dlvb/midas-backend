FROM openjdk:17-jdk-slim
LABEL maintainer="matushkin-2017@mail.ru"
EXPOSE 8181
ARG JAR_FILE=target/server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} server.jar
ENTRYPOINT ["java", "-jar", "/server.jar"]