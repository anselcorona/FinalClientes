FROM openjdk:8-jdk-alpine

LABEL maintainer="Ansel Corona <anselcorona@gmail.com>"

EXPOSE 8080

COPY ./build/libs/clientes-0.0.1-SNAPSHOT.jar finalclientes.jar

ENTRYPOINT ["java", "-jar", "finalclientes.jar"]
