# Step 6: From CI to CD

  * Previous step: [Building a CI stack](./step6.md)


We will here extend the CI stack defined in the previous step to support _Continuous Deployment_ (CD).

In our case, the deployment will be a turnkey docker image that will allow the enduser to use the product without having to install Java (assuming she has docker :wink:.

## Building a Docker Image

A docker image relies on a Dockerfile, which describes the steps to be executed to build the image.

In our case, the process is the following:

  1. Start from a fresh image that contains a Java Runtime Environment installed in a lightweight OS (_e.g._, Linux Alpine);
  2. State who is the maintainer of the image, for traceability purposes;
  3. Copy inside the image the JAR file that contains the product
  4. Give the command to be used to start the product.

### :bangbang: Exercise

  - Open the `Dockerfile` available at the root of the repository, and match the previously described process with its contents;
  - Build the docker image on your computer:
    - `azrael:agile-tutorial mosser$  docker build -t poker-game .` 
  - run the image in interactive mode (`-i`) using a pseudo TTY for I/O (`-t`), and remove the container when exiting the product (`-rm`) :
    - `azrael:agile-tutorial mosser$ docker run -it --rm poker-game:latest`
  - Delete the image from you local docker repository:
    - `azrael:agile-tutorial mosser$ docker rmi poker-game:latest` 

## Automating the Deployment

We need to extend the previously built stack at two different points:

  -  First, we need to setup a docker registry in our stack. We will use the official one, deployed on premises (one can also use the official Docker Hub, juste create an account on the Hub and go ahead);
  -  Secondly, we need to update the build descriptor to build the image and publish it.

### :bangbang: Exercise

  - Edit the `ci/docker-compose.yml` file to uncomment the lines that deploy the Docker registry;
  - Restart the stack : 
    - `azrael:ci mosser$ docker-compose down`
    - `azrael:ci mosser$ docker-compose up -d`
  - Edit the `.drone.yml` file to activate the `docker` step (uncomment the last lines)
  - commit your changes: 
    - `azrael:ci mosser$ git add -A; git commit -m "CI to CD"`
  - Push your changes to gitea:
    - `azrael:ci mosser$ git push gitea master`
  - Go to the Drone dashboard to follow the build process
  -  When the docker step is ended, you can explore the contents of your freshly populated docker registry:
    - [http://localhost:5000/v2/_catalog/](http://localhost:5000/v2/_catalog/)
    - [http://localhost:5000/v2/poker-game/tags/list](http://localhost:5000/v2/poker-game/tags/list)  
  - Pull the freshly registered image to your local computer:
    - `azrael:ci mosser$ docker pull localhost:5000/poker-game:latest`
  - Inspect the image metadata `azrael:agile-tutorial mosser$ docker image inspect localhost:5000/poker-game:latest`. Look at the information automatically added by the CI server for traceability.
  - Run the image:
    - `azrael:agile-tutorial mosser$ docker run -it --rm localhost:5000/poker-game:latest`
  - Too lazy to remember the full command line? Create an alias!
    - `azrael:agile-tutorial mosser$ alias pkg='docker run -it --rm localhost:5000/poker-game:latest'`
    - `azrael:agile-tutorial mosser$ pkg`
 

## Thanks for your attention!
   
<div align="center">
  
![That's all folks!](../pics/thats-all-folks.jpg)
  
</div>
  
  
### :bangbang: Optional Exercise

  - Look at the `ci/release-manager` directory. It is a custom docker image defined for the purpose of this tutorial. It basically extends the `nginx` web server by adding a very insecure`ssh` server inside the image and start it.
  - What do you think of the contents of the Dockerfile?  