# Building a Webchat on Monolithic Arthitecture

The main goal of this project is to compare it to the microservices architecture which can be found here : [Microservices](https://github.com/DimitrisHol/thesis-microservices/)

### This is a full stack web chat messenger. Technology Stack : 

* Front End Client on WebSocket (Javascript)
* Back End Server on Spring Framework (Java)
* Database is PostgreSQL running on Docker.


## Step 1 : Preparation : 

In order to run the app you first have to start an instance of PostgreSQL database.

**Preparing the Database**

### Using Docker to set up the database instance

For more information check the Postgres tutorial on [DockerHub](https://hub.docker.com/_/postgres)

   ```bash
   # Create a Postgres container
   docker run --name postgres-0 -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres

   # Obtain a shell to the docker container

   # Windows :
   winpty docker exec -it postgres-0 bash  

   # Linux / MacOS
   docker exec -it postgres-0 bash

   # Log into PostgresSQL
   psql -U postgres    

   # Create the database (only the first time)
   CREATE DATABASE thesischat

   \c thesischat       # Connect to database called thesischat
   ```

### Notes : 

 * Make sure that you followed the previous steps correctly, and have a postgres instance running.
 * There is a file in `resources/db.migration` that will take care of creating the tables automatically.
 * **Don't tinker with the tables** unless you add a new file named `resources/db.migration/V*__MODIFIED.sql` with * being last number +1. Otherwise the app **won't run**. 
 * In case you mess things up you can **just delete the database** and start over. (You don't have to change anything in the container.)


## Step 2 : Deploying : 

* Import the `pom.xml` file to your favourite IDE (IDEA Intelij Community was used)
* Launch the app (`/java/hello/Application.java`)
* You can access the chat through http://localhost:8400