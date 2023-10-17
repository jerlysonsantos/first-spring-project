#!/bin/sh

# Start the Spring Boot application
java -jar /app/your-spring-boot-app.jar &
# Start the Node.js application
NODE_ENV=production node --loader ts-node/esm /app/frontend/server/index.ts &

# Start Nginx
nginx -g "daemon off;"
