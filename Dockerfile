FROM openjdk:8-alpine

ADD ./target/spring-boot-example.jar .

CMD ["java", "-jar", "spring-boot-example.jar"]