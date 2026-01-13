# Employee-Management-System-Using-Java-JDBC

🧾 Project Overview

The Employee Management System is a console-based Java application developed using JDBC and PostgreSQL.
It provides a menu-driven interface that allows users to perform CRUD operations on employee records stored in a PostgreSQL database.
This project demonstrates practical implementation of Core Java, JDBC connectivity, DAO design pattern, and SQL operations.


✨ Features
  - Insert new employee details
  
  - Display all employee records
  
  - Fetch employee details using Employee ID
  
  - Update employee name based on Employee ID
  
  - Delete employee record using Employee ID

  
🛠 Technologies Used

  - Java (Core Java)
  
  - JDBC
  
  - PostgreSQL
  
  - SQL
  
  - Eclipse IDE


🧑‍💻 Application Flow

  1. User selects an option from the menu.
  
  2. The application performs the selected operation using JDBC.
  
  3. Data is stored and retrieved from a PostgreSQL database.
  
  4. Results are displayed on the console.


🏗 Project Structure

  Controller -->  Handles user interaction, menu-driven logic, and application flow.
  
  Dao --> Contains all database operations such as insert, update, delete, and fetch using JDBC.
  
  Entity --> Represents the Employee model and maps to the employee table in the database.
  
  Connection --> Manages PostgreSQL database connectivity, including JDBC driver loading and connection creation.
