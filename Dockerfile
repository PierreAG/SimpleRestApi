FROM amazoncorretto:17-alpine

WORKDIR /app
COPY target/spring-rest-api-1.0.0.jar /app/spring-rest-api.jar

EXPOSE 8081
CMD ["java", "-jar", "spring-rest-api.jar"]