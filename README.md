# Hotel Reservation System - Console Based Project(Java, MySQL)

🌞 Hey everyone! This is SRIRANGA GOPIKRISHNA G, and I'm excited to share my Hotel Reservation System project—a console-based application developed using Java and MySQL.

## 🔧 Tools Used:

- Eclipse IDE for Java development.
- Xampp server for MySQL database management.

## 📁 Project Setup:

- Integration of .Java class files in Eclipse IDE.
- Utilization of the database.properties file for MySQL server information.
- Establishment of a connection between Java code and the MySQL server using JDBC.

## 🛠️ Database Setup:

- Creation of the database: CREATE DATABASE hotel_reservation_system;
- Creation of tables: riresident, nriresident, room, booking, and payment.

## 💻 Modules and Packages:

**Modules:**
- RIResident
- NRIResident
- Room
- Booking
- Manager
- Payment

**Packages:**
- Client
- Model
- Service
- Util
- Management

## 👩‍💻 Workflow:

- Each module has a dedicated role in the structured project workflow.
- Packages ensure a professional and organized workflow.
- Instances and objects are created for inter-package communication.

## 🚀 RIResident Module:

- Definition of addRiResidentDetails() method in RIResidentService class to receive user input.
- Conversion of string input to ArrayList of Strings in ApplicationUtil class.
- Utilization of RIResidentManagement for database interactions.
- Methods in RIResidentManagement for add, update, and delete operations.

## 🔄 Key Methods in RIResidentService:

- addRiResidentDetails
- insertRIResidentIntoDB
- updateRIResidentPhoneNumberUsingResidentId
- updateOccupancyUsingResidentId
- updateRIResidentPhoneNumberUsingIdProof
- updateOccupancyUsingIdProof
- updateRIResidentPhoneNumberUsingContactNumber
- updateOccupancyUsingContactNumber
- deleteRIResidentDetailsFromDB

## 📚 What I Have Done:

- Establishing connections with MySQL.
- Database creation and table management.
- Console-based application development in Java.

