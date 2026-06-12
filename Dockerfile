# Etapa 1: Compilar
FROM eclipse-temurin:21-jdk-alpine AS build
COPY . .
# 1. Damos permisos primero
RUN chmod +x mvnw
# 2. Ejecutamos después
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecutar
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]r"]