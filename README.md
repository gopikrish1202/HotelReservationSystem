# Hotel Reservation System - Console Based Project(Java, MySQL)
[![Demo Video](https://drive.google.com/uc?export=view&id=1g0yTQMPVdl2DmBFEMpYyUY_WZ34zeRdN)](https://www.youtube.com/watch?v=yD5qWD_x50M)



🌞 Hey everyone! This is SRIRANGA GOPIKRISHNA G, and I'm excited to share my Hotel Reservation System project—a console-based application developed using Java and MySQL.

## 🔧 Tools Used:

- Eclipse IDE for Java development.
- Xampp server for MySQL database management.

## 📁 Project Setup:

- Integration of .java class files in Eclipse IDE.
- Utilization of the [`database.properties`](HotelReservationSystem/database.properties) file for MySQL server information.
- Establishment of a connection between Java code and the MySQL server using JDBC, which is present in [`DBConnectionManager.java`](HotelReservationSystem/src/com/management/DBConnectionManager.java)


## 🛠️ Database Setup:

- Creation of the database: using [`create_database.sql`](HotelReservationSystem_module1/hotel_reservation_system%20(database)/create_database.sql)
- Created required tables for the project, using the following queries:
  - [`riresident.sql`](HotelReservationSystem_module1/hotel_reservation_system%20(database)/riresident.sql)
  - [`nriresident.sql`](HotelReservationSystem_module1/hotel_reservation_system%20(database)/nriresident.sql)
  - [`room.sql`](HotelReservationSystem_module1/hotel_reservation_system%20(database)/room.sql)
  - [`booking.sql`](HotelReservationSystem_module1/hotel_reservation_system%20(database)/booking.sql)
  - [`payment.sql`](HotelReservationSystem_module1/hotel_reservation_system%20(database)/payment.sql)



## 💻 Modules and Packages:

**Modules:**
- RIResident
- NRIResident
- Room
- Booking
- Manager
- Payment

## Packages with respective java files
- ⭐ **[`Client`](HotelReservationSystem/src/com/client)**
  - 🔗 [`UserInterface.java`](HotelReservationSystem_module1/src/com/client/UserInterface.java)

- ⭐ **[`Model`](HotelReservationSystem/src/com/model)**
  - 🔗 [`Booking.java`](HotelReservationSystem_module1/src/com/model/Booking.java)
  - 🔗 [`Resident.java`](HotelReservationSystem_module1/src/com/model/Resident.java)
  - 🔗 [`RIResident.java`](HotelReservationSystem_module1/src/com/model/RIResident.java)
  - 🔗 [`NRIResident.java`](HotelReservationSystem_module1/src/com/model/NRIResident.java)
  - 🔗 [`Room.java`](HotelReservationSystem_module1/src/com/model/Room.java)
  - 🔗 [`Payment.java`](HotelReservationSystem_module1/src/com/model/Payment.java)

- ⭐ **[`Service`](HotelReservationSystem/src/com/service)**
  - 🔗 [`BookingService.java`](HotelReservationSystem_module1/src/com/service/BookingService.java)
  - 🔗 [`RIResidentService.java`](HotelReservationSystem_module1/src/com/service/RIResidentService.java)
  - 🔗 [`NRIResidentService.java`](HotelReservationSystem_module1/src/com/service/NRIResidentService.java)
  - 🔗 [`RoomService.java`](HotelReservationSystem_module1/src/com/service/RoomService.java)
  - 🔗 [`PaymentService.java`](HotelReservationSystem_module1/src/com/service/PaymentService.java)
  - 🔗 [`ManagerService.java`](HotelReservationSystem_module1/src/com/service/ManagerService.java)

- ⭐ **[`Util`](HotelReservationSystem/src/com/util)**
  - 🔗 [`ApplicationUtil.java`](HotelReservationSystem_module1/src/com/util/ApplicationUtil.java)

- ⭐ **[`Management`](HotelReservationSystem/src/com/management)**
  - 🔗 [`BookingManagement.java`](HotelReservationSystem_module1/src/com/management/BookingManagement.java)
  - 🔗 [`RIResidentManagement.java`](HotelReservationSystem_module1/src/com/management/RIResidentManagement.java)
  - 🔗 [`NRIResidentManagement.java`](HotelReservationSystem_module1/src/com/management/NRIResidentManagement.java)
  - 🔗 [`RoomManagement.java`](HotelReservationSystem_module1/src/com/management/RoomManagement.java)
  - 🔗 [`PaymentManagement.java`](HotelReservationSystem_module1/src/com/management/PaymentManagement.java)
  - 🔗 [`ManagerManagement.java`](HotelReservationSystem_module1/src/com/management/ManagerManagement.java)
  - 🔗 [`DBConnectionManager.java`](HotelReservationSystem_module1/src/com/management/DBConnectionManager.java)





## 👩‍💻 Workflow:

- Each module has a dedicated role in the structured project workflow.
- Packages ensure a professional and organized workflow.
- Instances and objects are created for inter-package communication.

## 🚀 RIResident Module:

- Definition of addRiResidentDetails() method in RIResidentService class to receive user input.
- Conversion of string input to ArrayList of Strings in ApplicationUtil class.
- Utilization of RIResidentManagement for database interactions.
- Methods in RIResidentManagement for add, update, retrieve and delete operations.


  ## 🚀 NRIResident Module:

- Definition of addNRiResidentDetails() method in NRIResidentService class to receive user input.
- Conversion of string input to ArrayList of Strings in ApplicationUtil class.
- Utilization of NRIResidentManagement for database interactions.
- Methods in NRIResidentManagement for add, update, retrieve and delete operations.

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

