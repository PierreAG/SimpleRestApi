FROM openjdk:17

WORKDIR /app
COPY target/spring-rest-api-1.0.0.jar /app/spring-rest-api.jar

EXPOSE 8585
CMD ["java", "-jar", "spring-rest-api.jar"]