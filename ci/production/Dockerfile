FROM node:16.15.1 as angular-builder

WORKDIR /app

COPY ./frontend/package*.json ./

RUN npm ci

COPY ./frontend/. .
RUN npm run build

FROM maven:3.8.1-openjdk-17-slim AS java-builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

COPY --from=angular-builder /app/dist/frontend /app/src/main/resources/static

RUN mvn clean package -DskipTests

# RUN mvn clean flyway:migrate -url= -user= -password= -schemas=

FROM openjdk:17-alpine

COPY --from=java-builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]