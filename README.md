# Java Spring Boot Project with PostgreSQL Integration

This project demonstrates how to integrate a Spring Boot backend with a PostgreSQL database. It will help entry-level developers connect the frontend to the backend by configuring their local PostgreSQL database and setting up the project.

## Prerequisites

Before running this project locally, make sure you have the following installed:

- **JDK 11+**: Make sure Java 11 or above is installed.
- **Maven**: Make sure Apache Maven is installed to build the project.
- **PostgreSQL**: You will need a local instance of PostgreSQL running on your machine.

## Setting Up PostgreSQL Database Locally

1. **Install PostgreSQL** (if you don't have it already):
   - For **Windows**: [PostgreSQL Windows Installation Guide](https://www.postgresql.org/download/windows/)
   - For **macOS**: You can use Homebrew: `brew install postgresql`
   - For **Linux**: Follow the instructions on [PostgreSQL Linux Installation](https://www.postgresql.org/download/linux/)

2. **Create a Database**:
   - Open the PostgreSQL command-line tool (`psql`) and run the following command to create a new database:
     ```sql
     CREATE DATABASE your_database_name;
     ```

3. **Create a User** (if you want to use a specific user for your Spring Boot application):
   - You can create a new PostgreSQL user with the following command:
     ```sql
     CREATE USER your_username WITH ENCRYPTED PASSWORD 'your_password';
     ```
   - Grant the necessary permissions to the user:
     ```sql
     GRANT ALL PRIVILEGES ON DATABASE your_database_name TO your_username;
     ```

## Configuring Spring Boot Application

1. **Clone the Project**:
   - Clone the project repository from GitHub:
     ```bash
     git clone https://github.com/Seraphin-Munga/employeeAdmin.git
     
     cd employeeAdmin
     ```

2. **Configure `application.properties`**:
   - Open `src/main/resources/application.properties` and update the database connection settings:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
     spring.jpa.hibernate.ddl-auto=update  # Automatically migrate tables when the app starts
     spring.jpa.show-sql=true
     ```

3. **Add PostgreSQL Dependency**:
   - If it's not already in your `pom.xml`, add the PostgreSQL dependency to enable connection:
     ```xml
     <dependency>
         <groupId>org.postgresql</groupId>
         <artifactId>postgresql</artifactId>
         <version>42.2.5</version>
     </dependency>
     ```

4. **Run the Spring Boot Application**:
   - Build and run the Spring Boot application using Maven:
     ```bash
     mvn spring-boot:run
     ```

   - Upon starting, the application will automatically connect to your PostgreSQL database and migrate the necessary tables as specified by your entity classes.

5. **Check the Migration**:
   - After the Spring Boot application starts, open your PostgreSQL database and check if the tables have been created automatically based on your entities.

   ```sql
   \c your_database_name
   \dt  # To list the tables in the database
