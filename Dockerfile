FROM openjdk:8-slim
VOLUME /tmp
ADD build/libs/spring-event-shuffle-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS="-Dmongo.host=mongodb"
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
