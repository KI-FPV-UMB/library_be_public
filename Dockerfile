FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/library-0.0.1-SNAPSHOT.jar /app/library-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/library-app.jar"]