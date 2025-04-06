# Etapa de Build
FROM maven:3.9.7-amazoncorretto-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml
COPY pom.xml /app

# Baixa as dependências Maven antes de copiar o código
RUN mvn dependency:go-offline -B

# Copia o código-fonte do projeto
COPY src /app/src

# Compila o projeto, ignorando os testes
RUN mvn -B clean package -DskipTests

# Etapa de Execução
FROM openjdk:21

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo jar gerado na etapa de build
COPY --from=build /app/target/dominio-bancario-0.0.1-SNAPSHOT.jar /app/app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para executar o aplicativo
CMD ["java", "-jar", "app.jar"]
