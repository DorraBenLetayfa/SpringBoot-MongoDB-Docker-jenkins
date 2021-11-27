FROM openjdk:8-alpine

WORKDIR /myworkspace

COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/myworkspace/app.jar"]

EXPOSE 8085