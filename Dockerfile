FROM maven:3.6.1 AS maven
LABEL MAINTAINER="thanhsangqn3@gmail.com"

WORKDIR /app
COPY . /app

# Compile and package the application to an executable JAR
RUN mvn package -DskipTests


# For Java 11
FROM openjdk:11

ARG JAR_FILE=challenge-0.0.1-SNAPSHOT.jar
WORKDIR /app

# Copy the challenge-0.0.1-SNAPSHOT.jar from the maven stage to the /app directory of the current stage.
COPY --from=maven /app/target/${JAR_FILE} /app

ENTRYPOINT ["java","-jar","challenge-0.0.1-SNAPSHOT.jar"]
