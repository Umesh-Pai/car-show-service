Car Show Service
----------------
Car Show Service consumes the Cars API and produces a list of the models of cars and the show they attended, grouped by make alphabetically.

Prerequisites
-------------
JDK: 1.8
Maven

Installation
-------------
For installing the application run the following maven command. This will generate a jar file named car-show-service.jar in the 'target' folder. This will run the JUnit test cases as well.

mvn clean install

Running the application
-----------------------
Run the following command from the folder containing the jar file to run the application.

java -jar car-show-service.jar

Accessing the application
-------------------------
Run the application as mentioned in the previous step. The generated jar will contain an embedded Tomcat server and it will run on 8091 port as specified in the 'application.properties' file. The application can be accessed using the below URI from any browser.

http://localhost:8091/api/v1/cars/show

Dependencies
------------
The following dependencies are required to run the application.

Spring Boot
Mockito
Junit