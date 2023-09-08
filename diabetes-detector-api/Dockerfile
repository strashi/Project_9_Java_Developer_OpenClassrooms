FROM eclipse-temurin:17-jdk-jammy

WORKDIR /mediscreen/diabetes-detector-api

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

EXPOSE 8083