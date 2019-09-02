# Ectools Importer
A simple stateless service that reads a CSV
file containing all the data regarding products and sends them as messages on a
message broker channel. The microservice also has an endpoint which accepts a csv 
amd reads the file containing new or update products.
## Getting Started

These instructions will get you a copy of the project up and running
on your local machine for development, testing and even to production.

### Prerequisites
You need to install the following and add to system paths.
```
docker
```
If you prefer not to run in a docker container install the following
```
java
maven
```

### Running
Clone or download repository and run maven in the root of the directory. A step by step
series of actions that tell you how to get project running. 
The application also contains a dockerfile. The application will run in a docker container.
#### Running application with docker container
```
project_root_directory > mvn clean package
```
Build the docker image 
```
project_root_directory> docker build -t ectools-importer .
```
Once the docker image has been built, you can run it using the command
```
project_root_directory> docker run -p 8080:8080 ectools-importer
```
#### Running the microservice with maven
```
project_root_directory > mvn clean  package
```
Compiles and builds classes and resources into jar file. A target folder 
is generated containing the build.
##### windows platform
```
project_root_directory > java -jar \target\ectools-importer-1.0.jar
```
##### unix platform
```
project_root_directory > java -jar /target/ectools-importer-1.0.jar
```
This will spin an embedded tomcat server and the application
can be accessed on localhost and port set in the application.properties
file in the source directory of the project
```
http://localhost:8080
```
### API Endpoints
```
http:localhost:8080/importer/read
```
This endpoint accepts a csv file. Containing all data about products.
## Deployment
The build in the target folder can be executed on cloud or server hosting platform.
You can also build the docker container and host on any cloud offering docker service.

## Built With
- SpringBoot
- Maven
- Java8

## Versioning
Version 1