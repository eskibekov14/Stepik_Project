
FROM openjdk:17

WORKDIR /app


COPY /build/libs/stepik-0.0.1-SNAPSHOT.jar backend.jar


EXPOSE 7070

CMD ["java", "-jar", "backend.jar"]
