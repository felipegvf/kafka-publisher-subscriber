FROM amazoncorretto:17-alpine
MAINTAINER felipegvf.github.io
LABEL authors="felipe"
COPY target/kafka-publisher-subscriber-0.0.1-SNAPSHOT.jar application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]