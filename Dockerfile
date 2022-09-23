FROM openjdk:12-jdk
MAINTAINER ecu.project.com
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} client.jar
ENTRYPOINT ["java","-jar","/client.jar"]