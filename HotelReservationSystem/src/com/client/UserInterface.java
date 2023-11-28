package com.client;

import java.util.*;

import com.model.RIResident;
import com.service.RIResidentService;

import java.sql.*;

public class UserInterface {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
    Scanner sc=new Scanner(System.in);
    System.out.println("WELCOME TO HOTEL RESERVATION SYSTEM");
    System.out.println("--------------------------------------------------------");
    
    
    System.out.println("1.RIResident Customer(Resident in India)");
    System.out.println("2.NRIResident Customer(NonResident in India)");
    System.out.println("3.Manager");
    System.out.println("Enter the user Type:");
    int userType=sc.nextInt();
    
    switch(userType) {
    case 1:
    	System.out.println("1.Add RIResident Details");
    	System.out.println("2.Book Room");
    	System.out.println("3.Manage Booking");
    	System.out.println("4.Cancel Booking");
    	System.out.println("5.View Booking");
    	
    
    	System.out.println("Enter the choice:");
    	int choice=sc.nextInt();
    	
    
    	if(choice==1){
    		System.out.println("Enter the number of RIResident customer Details wants to addd!!");
    		
    		int add=sc.nextInt();
    		sc.nextLine();
    		String []input=new String[add];
    		
    		System.out.println("input must be-->Name :Age :Gender :Phonenumber :Email :Address :Number of Adults :Number Of Children Above12 :Number of Children Above5 :Duration Of Stay :Resident type :Aadhar No ");
    		
    		for(int j=0;j<add;j++) {
    			input[j]=sc.nextLine();
    			}  		
    		
    		RIResidentService RiR=new RIResidentService();
    		List<RIResident> result=RiR.addRiResidentDetails(input);
    		
    		if(result.isEmpty()) 
    		{
    			System.out.println("Data are not added successfully");
    		}
    		else 
    		{
    			for(RIResident i:result) 
    			{
    				System.out.println(i.getResidentName()+" RIResident is Added Successfully and your RIResident Id is: "+i.getResidentId());
    			}
    		}
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	else if(choice==2) {
    		
    	System.out.println("Enter the Booking Id");
    	String id=sc.next();
    	
    	System.out.println("Enter the Booking CheckIn-Date");
    	String checkIn=sc.next();
    	
    	System.out.println("Enter the Booking CheckOut-Date");
    	String checkOut=sc.next();
    	
    	RIResidentService ris=new RIResidentService();
    	int update=ris.updateCheckInAndCheckOut(id,checkIn,checkOut);
    	
    	if(update==1)
    	{
    		System.out.println("Your Checkin Checkout date Updated Successfully");
    	}
    	else
    	{
    		System.out.println("Your Checkin Checkout date not Updated Successfully");
    	}
    	
    	
    	}
    	else if(choice==3) {
    		
    	}
    	else if(choice==4) {
    		
    	}
        else if(choice==4) {
    		
    	}
        else if(choice==5){
        	System.out.println("");
        }
    	
   
   
   
    
    	}
    
    
    
    
    
    
  
    	
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	}

}
