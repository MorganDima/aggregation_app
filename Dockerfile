FROM openjdk:17-jdk-slim

WORKDIR /usr/lib/locale

EXPOSE 8050

ADD target/aggregation-app-0.1.jar aggregation-app-0.1.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "aggregation-app-0.1.jar"]

ENV TZ Europe/Israel
