FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy project files to the container
COPY . .

# Build the JAR if it doesn't exist
RUN if [ ! -f target/patient-service-*.jar ]; then \
    echo "JAR not found, building with Maven..."; \
    ./mvnw package -DskipTests || mvn package -DskipTests; \
fi

# Copy the JAR to a known name
RUN cp target/patient-service-*.jar app.jar

# Use application-docker.properties instead of default
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.name=application-docker"]
