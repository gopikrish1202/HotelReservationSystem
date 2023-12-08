# HotelReservationSystem
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Reservation System Project</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            line-height: 1.6;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        p {
            color: #555;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }
    </style>
</head>

<body>

    <h1>Hotel Reservation System Project - Console Based (Java, MySQL)</h1>

    <p>🌞 Hey everyone! This is SRIRANGA GOPIKRISHNA G, as I walk you through my Hotel Reservation System project—a
        console-based application developed using Java and MySQL.</p>

    <h2>🔧 Tools Used:</h2>
    <ul>
        <li>Eclipse IDE for Java development.</li>
        <li>Xampp server for MySQL database management.</li>
    </ul>

    <h2>📁 Project Setup:</h2>
    <ul>
        <li>Integration of .Java class files in Eclipse IDE.</li>
        <li>Utilization of the database.properties file for MySQL server information.</li>
        <li>Establishment of a connection between Java code and the MySQL server using JDBC.</li>
    </ul>

    <h2>🛠️ Database Setup:</h2>
    <ul>
        <li>Creation of the database: CREATE DATABASE hotel_reservation_system;</li>
        <li>Creation of tables: riresident, nriresident, room, booking, and payment.</li>
    </ul>

    <h2>💻 Modules and Packages:</h2>
    <ul>
        <li><strong>Modules:</strong> RIResident, NRIResident, Room, Booking, Manager, Payment.</li>
        <li><strong>Packages:</strong> Client, Model, Service, Util, Management.</li>
    </ul>

    <h2>👩‍💻 Workflow:</h2>
    <ul>
        <li>Each module has a dedicated role in the structured project workflow.</li>
        <li>Packages ensure a professional and organized workflow.</li>
        <li>Instances and objects are created for inter-package communication.</li>
    </ul>

    <h2>🚀 RIResident Module:</h2>
    <ul>
        <li>Definition of addRiResidentDetails() method in RIResidentService class to receive user input.</li>
        <li>Conversion of string input to ArrayList of Strings in ApplicationUtil class.</li>
        <li>Utilization of RIResidentManagement for database interactions.</li>
        <li>Methods in RIResidentManagement for add, update, and delete operations.</li>
    </ul>

    <h2>🔄 Key Methods in RIResidentService:</h2>
    <ul>
        <li>addRiResidentDetails</li>
        <li>insertRIResidentIntoDB</li>
        <li>updateRIResidentPhoneNumberUsingResidentId</li>
        <li>updateOccupancyUsingResidentId</li>
        <li>updateRIResidentPhoneNumberUsingIdProof</li>
        <li>updateOccupancyUsingIdProof</li>
        <li>updateRIResidentPhoneNumberUsingContactNumber</li>
        <li>updateOccupancyUsingContactNumber</li>
        <li>deleteRIResidentDetailsFromDB</li>
        
    </ul>

    <h2>📚 What I Have Done:</h2>
    <ul>
        <li>Establishing connections with MySQL.</li>
        <li>Database creation and table management.</li>
        <li>Console-based application development in Java.</li>
    </ul>

</body>

</html>
