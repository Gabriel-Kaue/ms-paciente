FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/ms-consulta.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]