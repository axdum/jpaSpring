# testjpa_spring
## Description
School project : SIR TP2-4 Java Backend (JPA, REST API)<br><br>
Social network application that allows you to compare your electricity consumption with your friends, inspired by Opower.<br><br>
<b>TO DO </b>: Web interface.
<br><b>DONE</b> : Rest API to access users data.<br>
<img src="https://user-images.githubusercontent.com/31796081/36879851-fa103886-1dc5-11e8-8575-b6e5c164ed1f.png">
## Installation
0. Download and unzip project (you can remove -master in folder name).

1. Create database (name : jpaspring or open the `application.properties` file and set your own configurations for the
       MySQL database connection)
    
2. Build with Maven ```mvn clean install```  
    
3. Change directory to ```../testjpa_spring/target/```
     
4. Execute in the terminal ```java -jar testjpa_spring-0.0.1-SNAPSHOT.jar``` 
    
Alternatively run ```mvn spring-boot:run``` from command line or IDE or execute *axdum.master1.sir.testjpa_spring.TestjpaSpringApplication.main()* from within IDE.

Once the service is up and running the documentation of the REST API can be accessed at:
    
* API documentation JSON [http://localhost:8080/v2/api-docs/](http://localhost:8080/v2/api-docs)
* API documentation WEB UI [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Generate Javadoc and reports ```mvn site```
