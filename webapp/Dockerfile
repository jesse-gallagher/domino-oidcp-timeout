FROM maven:3-eclipse-temurin-17-alpine

WORKDIR /app

RUN mvn dependency:get -Dartifact=io.openliberty:openliberty-runtime:26.0.0.1:zip

COPY pom.xml /app/
RUN mvn dependency:go-offline

COPY src/ /app/src
RUN mvn package

ENTRYPOINT mvn liberty:run