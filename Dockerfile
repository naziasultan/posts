FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY target/post-0.0.1-SNAPSHOT.jar post-0.0.1.jar
ENTRYPOINT ["java","-jar","/post-0.0.1.jar"]