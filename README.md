# Robot Simulator REST service

This is a REST service simulating the movement of a robot in a potentially infinite grid. The service has been implemented using Spring Boot. 

There are several ways to get the service up and running:

1. Import the project into your preferred IDE and run Application.java as a java application.
2. mvn spring-boot:run 
3. Generate an executable jar:
* mvn clean install
* java -jar target/robot-simulator-1.0.0-SNAPSHOT.jar

After running the service, a Swagger documentation page will be available on localhost:8080. 

For the sake of simplicity, the database used is H2. The in-memory database is not configured to be persistent, so any changes will be lost after the service is stopped. 

The service has no security configuration. 
