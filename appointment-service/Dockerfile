FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy everything for build
COPY . .

# If JAR not found, build it
RUN if [ ! -f target/appointment-service-*.jar ]; then \
    echo "JAR not found, building with Maven..."; \
    ./mvnw package -DskipTests || mvn package -DskipTests; \
fi

# Rename the jar to a known name
RUN cp target/appointment-service-*.jar app.jar

# Use application-docker.properties explicitly
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.name=application-docker"]
