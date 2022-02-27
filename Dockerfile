FROM openjdk:11
ADD target/movie-catalog-service.jar movie-catalog-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","movie-catalog-service.jar"]