FROM maven:3.9.6-eclipse-temurin-21

WORKDIR /usr/local/app

COPY ./pom.xml ./

RUN mvn clean dependency:go-offline -B