package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.model.RIResident;

public class RIResidentManagement {

    public List<RIResident> insertRIResidentIntoDB(List<RIResident> riList) {
        try (Connection con = DBConnectionManager.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO riresident VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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

    public int updateRIResidentPhoneNumberUsingIdProofDB(long aad, long contact_number) throws SQLException {
        try (Connection con = DBConnectionManager.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("UPDATE riresident SET contact_number=?  WHERE idproof_aadharno=?")) {
            ps.setLong(1, contact_number);
            ps.setLong(2, aad);
            return ps.executeUpdate();
        }
    }

    public int updateRIResidentPhoneNumberUsingResidentIdDB(String rid, long contact_number) throws SQLException {
        try (Connection con = DBConnectionManager.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("UPDATE riresident SET contact_number=?  WHERE resident_id=?")) {
            ps.setLong(1, contact_number);
            ps.setString(2, rid);
            return ps.executeUpdate();
        }
    }

    public int updateRIResidentPhoneNumberUsingContactNumberDB(long old_con, long new_contact_number)
            throws SQLException {
        try (Connection con = DBConnectionManager.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("UPDATE riresident SET contact_number=?  WHERE contact_number=?")) {
            ps.setLong(1, old_con);
            ps.setLong(2, new_contact_number);
            return ps.executeUpdate();
        }
    }

    public int updateOccupancyUsingResidentIdDB(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5,
            String id) throws SQLException {
        try (Connection con = DBConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE riresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE resident_id=?")) {
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setString(4, id);
            return ps.executeUpdate();
        }
    }

    public int updateOccupancyUsingContactNumberDB(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5,
            long contact_number1) throws SQLException {
        try (Connection con = DBConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE riresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE contact_number=?")) {
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setLong(4, contact_number1);
            return ps.executeUpdate();
        }
    }

    public int updateOccupancyUsingIdProofDB(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, long aad1)
            throws SQLException {
        try (Connection con = DBConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE riresident SET number_of_adults=?, number_of_children_above12=?, number_of_children_above5=? WHERE idproof_aadharno=?")) {
            ps.setInt(1, noOfAdults);
            ps.setInt(2, noOfChildrenAbove12);
            ps.setInt(3, noOfChildrenAbove5);
            ps.setLong(4, aad1);
            return ps.executeUpdate();
        }
    }
    
    public int deleteRIResidentDetailsFromDB(String del_res) {
        try (Connection con = DBConnectionManager.getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM riresident WHERE resident_id = ?")) {
            // Execute the DROP TABLE statement
        	 ps.setString(1, del_res);
             return ps.executeUpdate();
             // Return success code or handle success in a way that makes sense for your application
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
            return 0; // Return failure code or handle failure in a way that makes sense for your application
        }
    }

   
}
