FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside the container
WORKDIR /app

# Copy the whole project for potential Maven build
COPY . .

# Build the JAR if not found
RUN if [ ! -f target/service-registry-*.jar ]; then \
    echo "JAR not found, building with Maven..."; \
    ./mvnw package -DskipTests || mvn package -DskipTests; \
fi

# Rename/copy the JAR to a consistent name
RUN cp target/service-registry-*.jar app.jar

# Use the docker-specific properties file
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.name=application-docker"]
