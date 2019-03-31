FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD eureka-1.0.0.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]