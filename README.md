# Flexisaf intenship task 1

## Project Description

This task involves creating a Java Spring Boot project and connecting it to a preffered database and using a build tool for the project.

For this project I used the following technologies:
- Database: PosgreSQL
- Build tool: Maven

## Approach
I used the [Spring Initializr](https://start.spring.io/) website to create the project by choosing Maven as my build tool, and I selected other dependencies for the project like:
- Spring starter jpa
- Spring web

The configuration for the database was set in the application.properties file.

The configuration requires setting the database url, driver, username, password and database platform, inside the application.properties file.

I disabled **spring jpa** in the main application class beacause I did not create any database entity.

The project contains a greetings controller that returns the message "Hello, welcome to my project".