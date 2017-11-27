Spring MVC and Thymeleaf with Maven xml based configuration.
====================================

- Spring MVC with Maven
- Web application (WAR) packaging as well as self-contained JAR
- Thymeleaf 
- WebJars
- Maven

Steps
--------------------
- Add Thymeleaf dependency to POM
- Create xml configuration file like /src/main/resources/thyme-leaf-context.xml
- Add nameSpace to the html file as like (<html xmlns:th="http://www.thymeleaf.org">)



Building the project
--------------------
> git clone https://github.com/proshantokuet/spring-thymeleaf-xmmlbased-config.git

Go to the newly created folder:

> cd spring-thymeleaf-xmmlbased-config

Run the project with:

> mvnw clean install

Deploy war to the Tomcat



