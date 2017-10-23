# Online Shopping website for Laptops
  It is an E-commerce website created for buying laptops.
  
## Prerequisites
  The following are the Softwares used for developing the project:
  1.Eclipse-Oxygen https://www.eclipse.org/
  2.H2 http://www.h2database.com/html/main.html
 
## This Project is divided into two modules:
 #  1.FrontEnd
 #  2.BackEnd
 
## Deployment
   The application can be accessed using http://172.23.172.217:8092/laptopsfrontend/ URL
   
## In the FrontEnd 
   The Frontend module comprises of Controllers, Jsp pages, Spring-Servlet and Spring Security Servlet. 
   There are 3 Controllers:
     1.Home Controller
     2.Admin Controller
     3.Cart Controller
   The Jsp pages provides the view of the pages displayed on the website.
   The Spring Security servlet provies the security for the website.
   # Prequistes used in Frontend are:
    1.Bootstrap http://getbootstrap.com/
    2.Jquery
    3.Html
   # Dependencies used:
    The dependencies are provided from https://mvnrepository.com/ URL
     * Spring dependencies like Spring-Core, Spring-Web,Spring-tx ....
     * Spring Security dependencies like Spring-Secutiry web, Spring-Security Core, Spring-Security Config, Spring-Security Taglibs
## Backend Module
   The Backend module consists of an Application config, DAO classes and Model Classes
   * In the Application Config beans are created using java.
   * The Model Classes are provided for creating tables in the database.
   * DAO classes provides the methods and functions. 
  # Dependencies used:
    The dependencies are provided from https://mvnrepository.com/ URL
    * Spring dependencies like Spring-Core, Spring-Web,Spring-tx ....
    * Hibernate dependencies like Hibernate Core, Hibernate Validator, Hibernate-entitymanager.
    
## Running the tests
   The Tests are done by using JUnit test http://junit.org/junit5/
    * One of the Examples of the Test Cases used is ProductTest.java. It is used to test the saving of data in the database table.
   This JUnit Test is used my implimenting the following Dependency
     <!-- https://mvnrepository.com/artifact/junit/junit -->
            <dependency>
            <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.12</version>
               <scope>test</scope>
            </dependency>
## Authors
   * A Saikiran Reddy - https://github.com/saikiran04/First-Project
    
    
   
    
     
  
