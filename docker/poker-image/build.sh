#!/bin/sh

DOCKER_USERNAME=petitroll
DOCKER_IMAGE_NAME=poker-game

echo "Compiling the Poker Game system"
cd ../..
cp target/poker-game.jar docker/poker-image/.
mvn clean package

echo "Building the docker image"
cd docker/poker-image
docker build -t $DOCKER_USERNAME/$DOCKER_IMAGE_NAME .
rm ./poker-game.jar

echo "To start a container running this image: docker run -it $DOCKER_USERNAME/$DOCKER_IMAGE_NAME:latest"

# If you need to publish the image to the docker hub, uncomment the following lines:
#echo "Publishing to the Docker Hub"
#docker push $DOCKER_USERNAME/$DOCKER_IMAGE_NAME
