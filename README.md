# Helmes Homework

Homework Solution for Accessing a Java Software Developer Position.

## Tasks

<b>1.</b> Correct all of the deficiencies in index.html

<b>2.</b> "Sectors" selectbox:
- Add all the entries from the "Sectors" selectbox to database
- Compose the "Sectors" selectbox using data from database

<b>3.</b> Perform the following activities after the "Save" button has been pressed:
- Validate all input data (all fields are mandatory)
- Store all input data to database (Name, Sectors, Agree to terms)
- Refill the form using stored data 
- Allow the user to edit his/her own data during the session

## Built With

* 	[Gradle](https://gradle.org/) - Dependency Management.
* 	[JDK](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html) - Amazon Coretto 17 x64 JDK.
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications.
* 	[H2](https://www.h2database.com/html/main.html) - Open-Source in-memory database.
* 	[ReactJS](https://react.dev) - React (also known as React.js or ReactJS) is a free and open-source front-end JavaScript framework.

## Running the server side (helmes-homework-api) project locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `ee.dmipet90.helmeshomework.api.HelmesHomeworkApiApplication` class from your IDE.

- Download the zip.
- Unzip the zip file
- Open Command Prompt and Change directory (cd) to folder containing gradle.build file
- Open your IDE 
   - File -> Open -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @HelmesHomeworkApiApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-running-your-application.html#using-boot-running-with-the-gradle-plugin) like so:

```shell
gradle bootRun
```

### packages

- `controller` — to listen to the client;
- `dto` — to hold DTO classes;
- `entity` — to hold entities;
- `exception` — to hold custom exceptions;
- `mapper` — to hold mapping interfaces;
- `model` — to hold request and response models;
- `repository` — to communicate with the database;
- `service` — to hold our business logic;
- `validation` — to hold validation helper classes;
- `resources/` - contains H2 database dump and property file.
- `resources/application.yml` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit and integration tests

- `gradle.build` - contains all the project dependencies

### Additional info

For a better demo experience, an H2 database is used with an attached SQl dump file containing the necessary initial data to start using this application.

H2 Database:
- H2 console url: `http://localhost:8787/h2-console`
- Driver class: `org.h2.Driver`
- JDBC url: `jdbc:h2:mem:helmes-homework-db`
- User: `sa`
- Password:
- SQL dump file location: `helmes-homework-api/src/main/resources/data.sql`


API base url:
- http://localhost:8787/api/v1/

## Running the client side (helmes-homework-fe) project locally

Navigate to the root foler of the project and run following commands:

```shell
npm install
npm start
```

### packages

- `component` — contains React JS components responsible for displaying the visual part of the application;
- `service` — contains functions for communicating with the API;

- `package.json` - contains all the project dependencies

### Additional info

Application url:
- http://localhost:3000


## Author

- <b>Dmitri Petrussevits</b> - Integration Developer