# Etapa de Build
FROM maven:3.9.7-amazoncorretto-17 AS build

WORKDIR /app
COPY pom.xml /app
COPY src /app/src

RUN mvn -B clean package -DskipTests

# Etapa de Execução
FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
COPY --from=build /app/target/dominio-bancario-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
