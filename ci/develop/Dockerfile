FROM node:14 as react-builder

WORKDIR /app

COPY ./frontend/package*.json ./

RUN npm ci

COPY ./frontend/. .

RUN npm run build

# Stage 2: Build Java Spring backend
FROM maven:3.8.1-openjdk-17-slim AS java-builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

# Stage 3: Run the Java Spring app
FROM openjdk:17-alpine

WORKDIR /app

COPY --from=java-builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]