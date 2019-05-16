FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD backend-0.0.3-DEV.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]