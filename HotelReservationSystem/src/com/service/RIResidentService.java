package com.service;
import com.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import com.management.RIResidentManagement;
import com.model.RIResident;
import com.util.ApplicationUtil;

public class RIResidentService {
	RIResident RiR;
	RIResidentManagement rim= new RIResidentManagement();
	public List<RIResident> addRiResidentDetails(String[]input) throws Exception {
		
		RIResidentManagement RiR=new RIResidentManagement();
	
		ApplicationUtil utilObj=new ApplicationUtil();
	    List<String> riRecords=utilObj.extractDetailsRI(input);
	    List<RIResident> riList=new ArrayList<RIResident>();
		riList=buildRIResidentList(riRecords);
		 List<RIResident> insertedRecord=RiR.insertRIResidentIntoDB(riList);
	
		
		return insertedRecord;
	}

	
	private List<RIResident> buildRIResidentList(List<String> riRecords){
		List<RIResident>riList=new ArrayList<RIResident>();
		int count =0;
		for(String ri:riRecords) {
			count++;
			String[]field=ri.split(":");
			String residentId=getResidentId(count);
			String residentName=field[0];
			int age=Integer.parseInt(field[1]);
			String gender=field[2];
			long contactNumber=Long.parseLong(field[3]);
			 String email=field[4];
			 String address=field[5];
			 int numberOfAdults=Integer.parseInt(field[6]);
			 int numberOfChildrenAbove12=Integer.parseInt(field[7]);
			 int numberOfChildrenAbove5=Integer.parseInt(field[8]);
			 int durationOfStay=Integer.parseInt(field[9]);
			 String residentType=field[10];
			 long idProofAadharNo=Long.parseLong(field[11]);
			 
			 RiR=new RIResident(residentId,residentName,age,gender,contactNumber,email,
			address,numberOfAdults,numberOfChildrenAbove12,numberOfChildrenAbove5,
			durationOfStay,residentType,idProofAadharNo);
			
			riList.add(RiR);
		}
		return riList;
	}
	
     
	
	
	

	public String getResidentId(int count)
	{
		int total=rim.getResidentId();
		total+=count;
		String s= "RIR"+total;
	
		return s;
	}
	
	
	
	
	public int updateRIResidentPhoneNumberUsingIdProof(long aad,long contact_number) throws SQLException
	{
		
			int i=rim.updateRIResidentPhoneNumberUsingIdProof(aad,contact_number);
			return i;
			
					
	}
		
	
	
	
	
	
	
	public int updateRIResidentPhoneNumberUsingResidentId(String rid, long contact_number) throws SQLException
			
	{
		
		  int i=rim.updateRIResidentPhoneNumberUsingResidentId(rid, contact_number);
		  return i;
		  
			
	}
	
	public boolean checkIdExists(String rid) {
		boolean i=rim.checkIdExists(rid);
		return i;
	}



	public int updateRIResidentPhoneNumberUsingContactNumber(long old_con, long new_contact_number)throws SQLException 
	{
		int i=rim.updateRIResidentPhoneNumberUsingContactNumber(old_con, new_contact_number);
		return i;
	}

	
	public int updateOccupancyUsingResidentId(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, String rid) throws SQLException 
		
		{
		
		int i=rim.updateOccupancyUsingResidentId(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,rid);
		return i;
			
			
		}
	
	
	public int updateOccupancyUsingIdProof(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, long aad1) throws SQLException
		
		{
			int i=rim.updateOccupancyUsingIdProof(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,aad1);
			return i;
					
		}
	

	public int updateOccupancyUsingContactNumber(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, long contact_number1) throws SQLException
	
	{
		int i=rim.updateOccupancyUsingContactNumber(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,contact_number1);
		return i;
		
	}


	 public int deleteRIResidentTable(String del_res) {
	        return rim.deleteRIResidentDetailsFromDB(del_res);
	       
	    }
	 
	
	 
	
	 

public List<RIResident> retrieveRIResidentDetails(String residentId){
	List<RIResident> list1=rim.retrieveRIResidentList(residentId);
	return list1;
}
}

//	
	
//		
	
	
	
	
