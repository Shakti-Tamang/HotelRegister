# Use OpenJDK 17 with Alpine Linux
FROM openjdk:17-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Set the working directory in the container
WORKDIR /app

# Copy the `pom.xml` to resolve dependencies
COPY pom.xml .

# Resolve dependencies and download them
RUN mvn dependency:resolve

# Copy the entire project source code into the container
COPY . .

# Build the application
RUN mvn package -DskipTests

# Expose the port your Spring Boot application uses
EXPOSE 8028

# Define the entry point for the container
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
