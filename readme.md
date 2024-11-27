# Spring Boot CRUD Application

## Description
This project demonstrates a Spring Boot CRUD application, as shown in the corresponding [video tutorial](https://www.youtube.com/@learnWithIfte). It covers the essential CRUD operations using Spring Boot, Thymeleaf, and MySQL as the database.

The repository contains the source code used in the tutorial video. Follow the steps below to clone and run the project in Spring Tool Suite (STS).

### Prerequisites
- **Java 17**
- **Spring Tool Suite (STS)**
- **MySQL Database**
- **Maven**

## Getting Started

### 1. Clone the Repository
To clone this project, open your terminal and run the following command:

```bash
git clone https://github.com/learnwithiftekhar/spring-boot-crud.git
```

### 2. Import the Project into Spring Tool Suite (STS)

1. Open STS.
2. Go to **File > Import > Maven > Existing Maven Projects.**
3. Browse to the folder where you cloned the repository and select it.
4. Click **Finish** to import the project. STS will build the project and download the dependencies specified in the ```pom.xml``` file.

### 3. Configure the Database Connection
This application uses a MySQL database. You’ll need to configure the ```application.yml``` file to set up the database connection.

Open ```src/main/resources/application.yml```.

Add the following configuration:
```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database_name
    username: your_database_username
    password: your_database_password
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect

```
Replace the placeholders:

- ```your_database_name```: The name of your MySQL database.
- ```your_database_username```: Your MySQL username.
- ```your_database_password```: Your MySQL password.

**Ensure that MySQL is running and the specified database is created.**

### 4. Run the Application

1. In STS, right-click on the project in the Project Explorer.
2. Select **Run As > Spring Boot App**.
3. The application will start, and you’ll see the log output in the console.

### 5. Access the Application
Once the application starts, you can access it at:
http://localhost:8080

To change the port, you can add a server.port entry in the application.yml file:

```yml
server:
  port: 8081

```

### Project Dependencies
The ``pom.xml`` file includes the following key dependencies:
- **Spring Boot Starter Data JPA**: For database interactions.
- **Spring Boot Starter Thymeleaf**: For the frontend templating engine.
- **Spring Boot Starter Web**: For building the REST API.
- **MySQL Connector**: For MySQL database connectivity.
- **Spring Boot Starter Validation**: For form validation.
- **Spring Boot Starter Test**: For testing the application.

## Additional Notes
**Database Migrations:** You may want to use a tool like Flyway or Liquibase if your application requires version control for database changes.
**Environment Variables:** For production, consider using environment variables or external configuration for sensitive information like database credentials.


Contact
For any questions or feedback, please reach out:
- **GitHub**: [Learn with iftekhar](https://github.com/learnwithiftekhar)
- **Email**: [learnwithiftekhar@gmail.com](mailto:learnwithiftekhar@gmail.com)
