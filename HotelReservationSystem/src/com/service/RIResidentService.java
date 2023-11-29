package com.service;
import com.model.*;
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
	    List<String> riRecords=utilObj.extractDetails(input);
	    List<RIResident> riList=new ArrayList<RIResident>();
		riList=buildRIResidentList(riRecords);
		 List<RIResident> insertedRecord=RiR.insertRIResidentIntoDB(riList);
	
		
		return insertedRecord;
	}

	
	private List<RIResident> buildRIResidentList(List<String> riRecords){
		List<RIResident>riList=new ArrayList<RIResident>();
		
		for(String ri:riRecords) {
			String[]field=ri.split(":");
			String residentId=getResidentId();
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
	
     
	static int idno=0;
	public static String  getResidentId()
	{
		
		
		idno++;

		String s= "RIR"+idno;
	
		return s;
	}
	
	
	
	
	public int updateRIResidentPhoneNumberUsingIdProof(long aad,long contact_number) throws SQLException
	{
		
			int i=rim.updateRIResidentPhoneNumberUsingIdProofDB(aad,contact_number);
			return i;
			
					
	}
		
	
	
	
	public int updateRIResidentPhoneNumberUsingResidentId(String rid, long contact_number) throws SQLException
			
	{
		
		  int i=rim.updateRIResidentPhoneNumberUsingResidentIdDB(rid, contact_number);
		  return i;
		  
			
	}



	public int updateRIResidentPhoneNumberUsingContactNumber(long old_con, long new_contact_number)throws SQLException 
	{
		int i=rim.updateRIResidentPhoneNumberUsingContactNumberDB(old_con, new_contact_number);
		return i;
	}

	
	public int updateOccupancyUsingResidentId(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, String rid) throws SQLException 
		
		{
		
		int i=rim.updateOccupancyUsingResidentIdDB(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,rid);
		return i;
			
			
		}
	
	
	public int updateOccupancyUsingIdProof(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, long aad1) throws SQLException
		
		{
			int i=rim.updateOccupancyUsingIdProofDB(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,aad1);
			return i;
					
		}
	

	public int updateOccupancyUsingContactNumber(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, long contact_number1) throws SQLException
	
	{
		int i=rim.updateOccupancyUsingContactNumberDB(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,contact_number1);
		return i;
		
	}


	 public int deleteRIResidentTable(String del_res) {
	        return rim.deleteRIResidentDetailsFromDB(del_res);
	       
	    }
	 }
	
	
	

//	
	
//		
	
	
	
	
