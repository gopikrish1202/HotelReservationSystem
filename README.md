# Hotel Reservation System - Console Based Project(Java, MySQL)
[![Demo Video](https://i9.ytimg.com/vi_webp/yD5qWD_x50M/mqdefault.webp?v=65688340&sqp=CKzIzasG&rs=AOn4CLCGII_H7EmSzP-lIx-MYR6YFOTT1g)](https://www.youtube.com/watch?v=yD5qWD_x50M&t=0s)

<iframe width="560" height="315" src="https://www.youtube.com/embed/yD5qWD_x50M?si=Q9_9lmqLcEncA_HW" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

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

## 🔄 Key Methods in RIResident module:

- addRiResidentDetails- to add Residential Indian customer's details
- insertRIResidentIntoDB - to send the user data of Indian customers to management package from the service package, in order to insert it into the database
- updateRIResidentPhoneNumberUsingResidentId - to update RI Resident phone number using resident Id
- updateOccupancyUsingResidentId - to update occupancy details of RI Resident using Resident Id
- updateRIResidentPhoneNumberUsingIdProof - to update RI Resident phone number of RI Resident using Aadhar ID proof
- updateOccupancyUsingIdProof - to update RI Resident occupancy using using Aadhar ID proof
- updateRIResidentPhoneNumberUsingContactNumber- to update the RI Residentphone number using the existing contact number
- updateOccupancyUsingContactNumber -  to update the RI Resident occupancy using contact number
- deleteRIResidentDetailsFromDB - to delete RI Resident details from the user (using Resident id)
- retrieveRIResidentDetails - to retrieve  RI Resident details from the database.

## 🔄 Key Methods in NRIResident module:

- addNRiResidentDetails- to add Non-Residential Indian customer's details
- insertNRIResidentIntoDB - to send the user data of NRI customers to management package from the service package, in order to insert it into the database
- updateNRIResidentPhoneNumberUsingResidentId - to update NRI Resident phone number using resident Id
- updateOccupancyUsingResidentId - to update occupancy details of NRI Resident using Resident Id
- updateNRIResidentPhoneNumberUsingIdProof - to update NRI Resident phone number of RI Resident using Aadhar ID proof
- updateOccupancyUsingIdProof - to update NRI Resident occupancy using using Aadhar ID proof
- updateNRIResidentPhoneNumberUsingContactNumber- to update the NRI Residentphone number using the existing contact number
- updateOccupancyUsingContactNumber -  to update the NRI Resident occupancy using contact number
- deleteNRIResidentDetailsFromDB - to delete RI Resident details from the user (using Resident id)
- retrieveNRIResidentDetails - to retrieve  RI Resident details from the database.














## 📚 What I Have Done:

- Establishing connections with MySQL.
- Database creation and table management.
- Console-based application development in Java.

