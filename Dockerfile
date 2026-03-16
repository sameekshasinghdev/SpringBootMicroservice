FROM eclipse-temurin:17
EXPOSE 8081
COPY target/SpringBootMicroservice-0.0.1-SNAPSHOT.jar book-service.jar
ENTRYPOINT ["java","-jar","/book-service.jar"]