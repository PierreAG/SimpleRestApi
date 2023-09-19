# Use the official OpenJDK base image with Java 17
FROM amazoncorretto:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from your build target directory into the container
COPY target/spring-rest-api-1.0.0.jar /app/spring-rest-api.jar

# Expose the port your Spring Boot application will run on (change this if needed)
EXPOSE 8080

# Define the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "spring-rest-api.jar"]