# Step 1: Dependencies
FROM eclipse-temurin:17-jdk-alpine AS dependencies
RUN apk add --no-cache maven
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline


# Step 2: Build
FROM dependencies AS builder
COPY src ./src
RUN mvn clean package -DskipTests


# Step 3: Runtime
FROM eclipse-temurin:17-jre-alpine AS runtime
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

