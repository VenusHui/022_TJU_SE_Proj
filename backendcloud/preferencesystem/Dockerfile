FROM openjdk:18-jdk-alpine
VOLUME /tmp
ADD backendcloud/preferencesystem/target/preferencesystem-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7003
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
