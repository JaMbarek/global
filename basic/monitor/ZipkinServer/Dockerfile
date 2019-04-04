FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD zipkin-server-1.0.0.jar app.jar
EXPOSE 10004
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]