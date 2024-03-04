FROM openjdk:17-slim
WORKDIR /
LABEL authors="Sergey"
COPY target/paragraph7_2-0.0.1.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
