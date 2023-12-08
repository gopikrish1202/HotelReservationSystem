package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.*;
import com.service.*;

public class NRIResidentManagement {

    public List<NRIResident> insertNRIResidentIntoDB(List<NRIResident> NriList) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Nriresident VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? , ?)");

            for (NRIResident nr : NriList) {
                ps.setString(1, nr.getResidentId());
                ps.setString(2, nr.getResidentName());
                ps.setInt(3, nr.getAge());
                ps.setString(4, nr.getGender());
                ps.setLong(5, nr.getContactNumber());
                ps.setString(6, nr.getEmail());
                ps.setString(7, nr.getAddress());
                ps.setInt(8, nr.getNumberOfAdults());
                ps.setInt(9, nr.getNumberOfChildrenAbove12());
                ps.setInt(10, nr.getNumberOfChildrenAbove5());
                ps.setInt(11, nr.getDurationOfStay());
                ps.setString(12, nr.getResidentType());
                ps.setString(13, nr.getPassportNo());
                ps.setString(14, nr.getPassportType());
                ps.setString(15, nr.getNationality());
                ps.setString(16, nr.getPurposeForVisit());

                ps.addBatch();
            }

            // Execute batch after adding all batches in the loop
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }

        return NriList;
    }

    
    
    
    
    public int getResidentId() {
        int total = 0;
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM nriresident");

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                total = resultSet.getInt(1);
                return total;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }

        return 0;
    }
    
    
    
    

    public int updateNRIResidentPhoneNumberUsingResidentId(String residentid, long contact_number) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE nriresident SET contact_number=? WHERE resident_id=?");
            ps.setLong(1, contact_number);
            ps.setString(2, residentid);

            return ps.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception or log it
            e.printStackTrace();
            return 0; // Return an appropriate value or throw an exception based on your error handling strategy
        }
    }

    
    
    
    
    public int updateNRIResidentPhoneNumberUsingPassportNumber(String pas, long contact_number) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE nriresident SET contact_number=? WHERE passport_no=?");
            ps.setLong(1, contact_number);
            ps.setString(2, pas);

            return ps.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception or log it
            e.printStackTrace();
            return 0; // Return an appropriate value or throw an exception based on your error handling strategy
        }
    }

    
    
    
    public int updateRIResidentPhoneNumberUsingContactNumber(long old_con, long new_contact_number) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE nriresident SET contact_number=? WHERE resident_id=?");
            ps.setLong(1, new_contact_number);
            ps.setLong(2, old_con);

            return ps.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception or log it
            e.printStackTrace();
            return 0; // Return an appropriate value or throw an exception based on your error handling strategy
        }
    }
    
    
    
    
    

    public List<NRIResident> retrieveNRIResidentList(String residentId) {
        List<NRIResident> resultList = new ArrayList<>();
        RIResidentService ris = new RIResidentService();
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM nriresident WHERE resident_id=?");
            ps.setString(1, residentId);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                NRIResident re = new NRIResident(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10),
                        resultSet.getInt(11), resultSet.getString(12), resultSet.getString(13),
                        resultSet.getString(14), resultSet.getString(15), resultSet.getString(16));
                resultList.add(re);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }
        return resultList;
    }

    
    
  
    
    public boolean checkIdExists(String residentId) {
        String sql = "SELECT COUNT(*) FROM nriresident WHERE resident_id = ?";
        boolean idExists = false;

        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, residentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            try {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    idExists = count > 0;
                }
            } finally {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return idExists;
    }

    
    
    
    
    public int deleteNRIResidentDetailsFromDB(String del_res) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM nriresident WHERE resident_id = ?");
            ps.setString(1, del_res);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return 0; // Return failure code or handle failure in a way that makes sense for your application
        }
    }
    
    
    
    

    public int updateOccupancyUsingResidentId(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5,
            String id) throws SQLException {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE nriresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE resident_id=?");
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setString(4, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return 0;
        }
    }
    
    
    
    

    public int updateOccupancyUsingContactNumber(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5,
            long contact_number1) throws SQLException {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE riresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE contact_number=?");
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setLong(4, contact_number1);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return 0;
        }
    }

    
    
    
    public int updateOccupancyUsingPassportNumber(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5,
            String pas) throws SQLException {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE riresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE passport_no=?");
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setString(4, pas);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return 0;
        }
    }
}
