# ## Stage 1 : build with maven builder image with native capabilities
# FROM quay.io/quarkus/centos-quarkus-maven:20.1.0-java11 AS build
# COPY . /tmp/my-project
# USER root
# RUN chown -R quarkus /tmp/my-project
# USER quarkus
# WORKDIR /tmp/my-project
# RUN mvn clean package

# ## Stage 2 : create the docker final image
# FROM registry.access.redhat.com/ubi8/ubi-minimal
# WORKDIR /usr/src/app/target/
# COPY --from=build /tmp/my-project/target/*-runner /usr/src/app/target/application
# RUN chmod 775 /usr/src/app/target
# EXPOSE 8080
# CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]

FROM openjdk:8-jdk

RUN mkdir /app

COPY one-login-mock-1.0.0-SNAPSHOT.jar /app/quarkus-app.jar

WORKDIR /app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-app.jar"]