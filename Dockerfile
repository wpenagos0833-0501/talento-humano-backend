# Etapa 1: Compilar
FROM eclipse-temurin:21-jdk-alpine AS build
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecutar
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]