FROM maven:3.8.4-openjdk-17 AS builder


COPY pom.xml /tmp/
WORKDIR /tmp
RUN mvn dependency:go-offline

COPY . /tmp/
RUN mvn -B package --file /tmp/pom.xml

FROM openjdk:17

COPY --from=builder /tmp/target/*.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]


