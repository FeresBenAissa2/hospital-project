FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy only relevant files first for better layer caching
COPY . .

# If JAR not found, build it
RUN if [ ! -f target/api-gateway-*.jar ]; then \
    echo "JAR not found, building with Maven..."; \
    ./mvnw package -DskipTests || mvn package -DskipTests; \
fi

# Rename the jar to a known name for easier reference
RUN cp target/api-gateway-*.jar app.jar

# Use application-docker.properties explicitly
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.name=application-docker"]
