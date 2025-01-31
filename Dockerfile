# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file into the container
COPY ./pom.xml /app/

# Run `mvn dependency:go-offline` to download dependencies
RUN mvn dependency:go-offline -B

# Copy the rest of the project
COPY ./src /app/src

# Build the project
RUN mvn clean package

# Use a smaller base image for running the application
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from the builder stage
COPY --from=builder /app/target/your-app.jar /app/your-app.jar

# Expose the port your app runs on (if applicable)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/your-app.jar"]
