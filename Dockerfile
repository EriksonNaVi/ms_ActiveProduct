FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/ms_ActiveProduct-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar","/app.jar"]