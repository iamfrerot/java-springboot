FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/SimpleJavaApi-0.0.1.jar SimpleJavaApi.jar
EXPOSE 1010
ENTRYPOINT ["java","-jar","SimpleJavaApi.jar"]
