FROM openjdk:19
LABEL maintainer="javaguides.net"
ADD target/SpringMongoProject-0.0.1-SNAPSHOT.jar SpringMongoProject.jar
ENTRYPOINT ["java", "-jar", "SpringMongoProject.jar"]