# Spring Boot, Spring MVC, JSP, Spring Security,  JPA, Wildfly 9 and Docker example 

## Prerequisites:
* Docker 
* JDK 1.8 
* Maven 3.*


## Install and run the project 
1. download/clone the project 
2. Build the project using following maven command from project root folder where pom.xml file place.
  * `mvn clean package`
3. Create docker image from following command 
  * `docker build -t assignment_image .`
4. Run the docker-compose using the following command   
  * `docker-compose up`
  
5. Open the browser and hit the url.
  * `http://localhost:8080/assignment/`
6. you can use following user account to login the application.
   * Username = ahmed, password = password
   * Username = mukhtiar, password = password
   * Username = admin, password = password

> **Note:** Dockerfile and docker-compose.yml files are in project root dir.


