FROM node:16.15.1 as react-builder

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

RUN mvn package -DskipTests

# RUN mvn clean flyway:migrate -url= -user= -password= -schemas=

FROM node:16.15.1
RUN apt-get update \
     && apt-get install default-jre -y \
     && apt-get install default-jdk -y


COPY --from=java-builder /app/target/*.jar app.jar
COPY --from=react-builder /app/ /app/frontend/

COPY ./ci/production/nginx.conf /etc/nginx/nginx.conf
COPY ./ci/production/entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

EXPOSE 80

ENTRYPOINT ["/entrypoint.sh"]