FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
ARG JAR_FILE=./build/libs/docker-demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} person-app.jar
ENTRYPOINT ["java","-jar","person-app.jar"]
