# =============================================================================
# FILE: Dockerfile
# Multi-stage build for optimized Spring Boot container
# =============================================================================

# Stage 1: Build stage (not needed as we build in CI, but shown for completeness)
FROM eclipse-temurin:17-jre-jammy AS builder
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

RUN java -Djarmode=layertools -jar app.jar extract

# Stage 2: Runtime stage
FROM eclipse-temurin:17-jre-alpine

# Add labels for metadata
LABEL maintainer="devops@example.com"
LABEL description="Hello World Spring Boot Application"
LABEL version="1.0.0"

# Create non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Set working directory
WORKDIR /app

# Copy JAR from target directory (built in CI pipeline)
COPY target/*.jar app.jar

# Change ownership to non-root user
RUN chown -R appuser:appgroup /app

# Switch to non-root user
USER appuser

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# JVM options for container
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -Djava.security.egd=file:/dev/./urandom"

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

