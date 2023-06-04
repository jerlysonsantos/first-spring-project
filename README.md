### run migrations

`mvn clean flyway:migrate -Dflyway.configFiles=src/main/resources/flywayConfig.conf`

### run application

`mvn spring-boot:run`
