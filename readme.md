========================================
HomeBase - Team 02

========================================
1. Project Overview
----------------------------------------
This is a simple Java CLI application for managing real estate listings. 
It supports adding, updating, deleting, and viewing Sellers, Agents, and Homes. 

========================================
2. Environment Requirements
----------------------------------------
- Java JDK 17
- MySQL Server 8.0 or later
- mysql-connector-java-8.0.33.jar

Operating System: MacOS or Windows

========================================
3. Steps to Create the Database
----------------------------------------
Open your MySQL client and follow these steps:

a) Create Database
------------------------
CREATE DATABASE HomeBaseDB;

USE HomeBaseDB;

b) Create Tables
------------------------
Run the SQL file:
HomeBase_create.sql

c) Insert Sample Data
------------------------
Run the SQL file:
HomeBase_insert.sql

This will create all tables and load test data.

========================================
4. Steps to Compile and Run the App
----------------------------------------

a) Folder Structure
------------------------
HomeBaseProject/
  src/
    DataBaseConnection.java
    SellerDAO.java
    AgentDAO.java
    HomeDAO.java
  lib/
    mysql-connector-java-8.0.33.jar

b) Go to the src folder in terminal
------------------------
cd src

c) 🚀Compile it 
------------------------
javac -cp ".:../lib/*" *.java

(Windows users use ; instead of : )

javac -cp ".;../lib/*" *.java

d) Run
------------------------
MAC/Linux /🐧：java -cp ".:../lib/*" Main

(Windows users use ; instead of : )
🪟：java -cp ".;../lib/*" Main

e) Using the App
------------------------
- Follow the on-screen menu.
- You can Add, Update, Delete, and List Sellers, Agents, and Homes.
- The menu loops back after every action.
-------------------------
1) Manage Homes
2) Manage Sellers
3) Manage Viewings
4) Exit
   Enter choice:

-------------------------
Manage Homes Workflow:

1) Add Home
2) Update Home Price
3) Delete Home
4) List All Homes
5) Back to Main Menu
   Enter choice:

-------------------------
Manage Sellers Workflow:

1) Add Seller
2) Update Seller
3) Delete Seller
4) List All Sellers
5) Back to Main Menu
   Enter choice:
-------------------------
Manage Viewings Workflow:

1) Add Viewing
2) Update Viewing Date
3) Delete Viewing
4) List All Viewings
5) Back to Main Menu
   Enter choice:
-------------------------

========================================
5. Video URL
----------------------------------------

========================================
6. Additional Notes
----------------------------------------
- Make sure MySQL Server is running.
- The user/password in DatabaseConnection.java must match your local MySQL setup.
- Use correct connector JAR path in lib/.

========================================
7. Team Members and Contributions
----------------------------------------
- : SellerDAO
- : AgentDAO
- : HomeDAO
- : Main.java and DatabaseConnection.java

========================================
