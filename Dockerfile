FROM openjdk:8
ADD target/microservice-adhesion.jar microservice-adhesion.jar
EXPOSE 1234
ENTRYPOINT ["java","-jar","microservice-adhesion.jar"]