FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD gateway-1.0.0.jar app.jar
EXPOSE 10005
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]