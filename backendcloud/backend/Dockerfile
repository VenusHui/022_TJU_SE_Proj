FROM openjdk:18-jdk-alpine
VOLUME /tmp
ADD backendcloud/backend/target/backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
