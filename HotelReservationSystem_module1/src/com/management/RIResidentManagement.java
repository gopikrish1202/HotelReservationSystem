package com.management;

import com.service.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.RIResident;

public class RIResidentManagement {

    Connection con = DBConnectionManager.getConnection();

    public List<RIResident> insertRIResidentIntoDB(List<RIResident> riList) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO riresident VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            for (RIResident r : riList) {
                ps.setString(1, r.getResidentId());
                ps.setString(2, r.getResidentName());
                ps.setInt(3, r.getAge());
                ps.setString(4, r.getGender());
                ps.setLong(5, r.getContactNumber());
                ps.setString(6, r.getEmail());
                ps.setString(7, r.getAddress());
                ps.setInt(8, r.getNumberOfAdults());
                ps.setInt(9, r.getNumberOfChildrenAbove12());
                ps.setInt(10, r.getNumberOfChildrenAbove5());
                ps.setInt(11, r.getDurationOfStay());
                ps.setString(12, r.getResidentType());
                ps.setLong(13, r.getIdProofAadharNo());
                ps.addBatch();
            }

            // Execute batch after adding all batches in the loop
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }

        return riList;
    }

    public int updateRIResidentPhoneNumberUsingResidentId(String residentid, long contact_number) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE riresident SET contact_number=? WHERE resident_id=?");
            ps.setLong(1, contact_number);
            ps.setString(2, residentid);

            return ps.executeUpdate();
        } catch (SQLException e) {
            // Handle the exception or log it
            e.printStackTrace();
            return 0; // Return an appropriate value or throw an exception based on your error handling strategy
        }
    }

    public int updateRIResidentPhoneNumberUsingIdProof(long aad, long contact_number) throws SQLException {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE riresident SET contact_number=?  WHERE idproof_aadharno=?");
            ps.setLong(1, contact_number);
            ps.setLong(2, aad);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            throw e;
        }
    }

    public boolean checkIdExists(String residentId) {
        String sql = "SELECT COUNT(*) FROM riresident WHERE resident_id = ?";
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

    public int updateRIResidentPhoneNumberUsingContactNumber(long old_con, long new_contact_number)
            throws SQLException {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE riresident SET contact_number=?  WHERE contact_number=?");
            ps.setLong(1, old_con);
            ps.setLong(2, new_contact_number);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            throw e;
        }
    }

    public int updateOccupancyUsingResidentId(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5,
            String id) throws SQLException {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE riresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE resident_id=?");
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setString(4, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            throw e;
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
            throw e;
        }
    }

    public int updateOccupancyUsingIdProof(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, long aad1)
            throws SQLException {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE riresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE idproof_aadharno=?");
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setLong(4, aad1);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return 0;
        }
    }

    public int deleteRIResidentDetailsFromDB(String del_res) {
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM riresident WHERE resident_id = ?");
            // Execute the DROP TABLE statement
            ps.setString(1, del_res);
            return ps.executeUpdate();
            // Return success code or handle success in a way that makes sense for your application
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return 0; // Return failure code or handle failure in a way that makes sense for your application
        }
    }

    public List<RIResident> retrieveRIResidentList(String residentId) {
        List<RIResident> resultList = new ArrayList<>();
        RIResidentService ris = new RIResidentService();
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM riresident WHERE resident_id=?");
            ps.setString(1, residentId);
            // Execute the query and get the result set
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                // Process the result set if needed
                RIResident re = new RIResident(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getString(4), resultSet.getLong(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getInt(11),
                        resultSet.getString(12), resultSet.getLong(13));
                resultList.add(re);

            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }
        return resultList;
    }

    public int getResidentId() {
        int total;
        try {
            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM riresident");

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
}
