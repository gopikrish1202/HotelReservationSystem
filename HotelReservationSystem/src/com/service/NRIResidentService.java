package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.management.RIResidentManagement;
import com.service.*;
import com.model.*;
import com.management.*;
import com.util.*;

public class NRIResidentService {
	
	NRIResidentManagement nrim=new NRIResidentManagement();
	NRIResident nrir;

public List<NRIResident> addNRiResidentDetails(String[]input) throws Exception {
		
		
	
		ApplicationUtil utilObj=new ApplicationUtil();
	    List<String> NriRecords=utilObj.extractDetailsNRI(input);
	    List<NRIResident> NriList=new ArrayList<NRIResident>();
		NriList=buildNRIResidentList(NriRecords);
		 List<NRIResident> insertedRecord=nrim.insertNRIResidentIntoDB(NriList);
	
		
		
		return insertedRecord;
	}



private List<NRIResident> buildNRIResidentList(List<String> NriRecords){
    List<NRIResident> nriList = new ArrayList<>();
    int count = 0;
    for(String Nri : NriRecords) {
        count++;
        String[] field = Nri.split(":");
        String residentId = getResidentId(count);
        String residentName = field[0];
        int age = Integer.parseInt(field[1]);
        String gender = field[2];
        long contactNumber = Long.parseLong(field[3]);
        String email = field[4];
        String address = field[5];
        int numberOfAdults = Integer.parseInt(field[6]);
        int numberOfChildrenAbove12 = Integer.parseInt(field[7]);
        int numberOfChildrenAbove5 = Integer.parseInt(field[8]);
        int durationOfStay = Integer.parseInt(field[9]);
        String residentType = field[10];
        String passportNo = field[11];
        String passportType = field[12];
        String nationality = field[13];
        String purposeOfVisit = field[14];

        nrir = new NRIResident(residentId, residentName, age, gender, contactNumber, email,
                address, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5,
                durationOfStay, residentType, passportNo, passportType, nationality, purposeOfVisit);

        nriList.add(nrir);
    }
    return nriList;
}




public String getResidentId(int count)
{
	int total=nrim.getResidentId();
	total+=count;
	String s= "RIR"+total;

	return s;
}


public int updateNRIResidentPhoneNumberUsingResidentId(String rid, long contact_number) throws SQLException{
	int i=nrim.updateNRIResidentPhoneNumberUsingResidentId(rid,contact_number);
	return i;
}






public int updateNRIResidentPhoneNumberUsingPassportNumber(String pas,long contact_number) throws SQLException
{
	
		int i=nrim.updateNRIResidentPhoneNumberUsingPassportNumber(pas,contact_number);
		return i;
		
				
}



public int updateNRIResidentPhoneNumberUsingContactNumber(long old_con, long new_contact_number)throws SQLException 
{
	int i=nrim.updateRIResidentPhoneNumberUsingContactNumber(old_con, new_contact_number);
	return i;
}



public boolean checkIdExists(String rid) {
	boolean i=nrim.checkIdExists(rid);
	return i;
}

public List<NRIResident> retrieveNRIResidentDetails(String residentId){
	List<NRIResident> list1=nrim.retrieveNRIResidentList(residentId);
	return list1;
}

public int deleteNRIResidentTable(String del_res) {
    return nrim.deleteNRIResidentDetailsFromDB(del_res);
   
}



public int updateOccupancyUsingResidentId(int adults_a, int child_12_a, int child_5_a, String rid1) throws SQLException {
	int i=nrim.updateOccupancyUsingResidentId(adults_a, child_12_a, child_5_a, rid1);
	return i;
}

public int updateOccupancyUsingContactNumber(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, long contact_number1) throws SQLException

{
	int i=nrim.updateOccupancyUsingContactNumber(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,contact_number1);
	return i;
	
}

public int updateOccupancyUsingPassportNumber(int noOfAdults, int noOfChildrenAbove12, int noOfChildrenAbove5, String pas) throws SQLException

{
	int i=nrim.updateOccupancyUsingPassportNumber(noOfAdults, noOfChildrenAbove12, noOfChildrenAbove5,pas);
	return i;
			
}


}
