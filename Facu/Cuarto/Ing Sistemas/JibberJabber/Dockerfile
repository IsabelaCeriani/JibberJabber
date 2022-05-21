#FROM openjdk:8-jdk-alpine
#MAINTAINER baeldung.com
#COPY ./build/libs/*.jar /app/spring-boot-application.jar
#ENTRYPOINT ["java","-jar","/JibberJabber-0.1.0.jar"]
#


FROM openjdk:17-alpine3.12 AS build
EXPOSE 8080
RUN mkdir /app
COPY ./build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=production", "/app/spring-boot-application.jar"]