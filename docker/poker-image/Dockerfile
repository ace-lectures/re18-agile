# Requiring a Java 8 JRE, based on Alpine Linux (light distribution)
FROM openjdk:8-jre-alpine

# Who is in charge of the deployment image
LABEL maintainer="Sébastien Mosser (mosser@i3s.unice.fr)"

# Copying the built JAR inside the image
COPY ./poker-game.jar ./poker-game.jar

# How to start the shipped artefact
ENTRYPOINT ["java", "-cp", "./poker-game.jar"]

# Default parameter (here run the Main class)
CMD ["re.poker.Main"]
