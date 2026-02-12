# Multi-stage build for Java Spring Boot application

# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the jar file from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Set default environment variables (can be overridden at runtime)
ENV SERVER_PORT=8080
ENV MONGODB_URI=mongodb://localhost:27017/employeedb

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
