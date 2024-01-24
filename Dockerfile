FROM openjdk:11

RUN mkdir /app

COPY . /app/

WORKDIR /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]
