# Requiring a Java 8 JRE, based on Alpine Linux (light distribution)
FROM openjdk:8-jre-alpine

# Who is in charge of the deployment image
LABEL maintainer="Sébastien Mosser (mosser@i3s.unice.fr)"

# Copying the built JAR inside the image
COPY ./target/poker-game.jar ./poker-game.jar

# Starts the poker-game executab;e
CMD ["java", "-jar", "./poker-game.jar"]
