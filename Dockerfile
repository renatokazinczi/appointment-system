FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/appointment-system-*.jar appointment-system.jar
EXPOSE 8080
CMD ["java","-jar","appointment-system.jar"]