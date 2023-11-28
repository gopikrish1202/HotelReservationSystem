package com.management;

import java.util.*;
import java.sql.*;

import com.model.RIResident;
import com.util.ApplicationUtil;

public class RIResidentManagement {

	public List<RIResident> insertRIResidentIntoDB(List<RIResident> riList) {

		// TODO Auto-generated method stub
		for(RIResident r:riList) {
		try {
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into riresident values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,r.getResidentId());
				ps.setString(2,r.getResidentName());
				ps.setInt(3,r.getAge());
				ps.setString(4, r.getGender());
				ps.setLong(5,r.getContactNumber());
				ps.setString(6,r.getEmail());
				ps.setString(7,r.getAddress());
				ps.setInt(8, r.getNumberOfAdults());
				ps.setInt(9,r.getNumberOfChildrenAbove12());
				ps.setInt(10,r.getNumberOfChildrenAbove5());
				ps.setInt(11, r.getDurationOfStay());
				ps.setString(12, r.getResidentType());
				ps.setLong(13, r.getIdProofAadharNo());
				ps.addBatch();
				ps.execute();
				
			
				
			}
		catch(SQLException e) {
				System.out.println(r.getResidentName()+" is not added successfully because of "+e.getMessage());
			}
		}
//		saran:23:M:1472583699:SARAN@gmail.com:kmbakonam:5:2:2:3:nonAc:123456789
		
		return riList;
	}
	
	public int updateCheckInAndCheckOutDB(String id,String checkIn,String checkOut) throws SQLException
	{
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE Paymenet SET checkIn=?,checkOut=? WHERE id=?");
		ps.setString(1, id);
		ps.setString(2, checkIn);
		ps.setString(3, checkOut);
		int i=ps.executeUpdate();
		return i;
		
}
}
