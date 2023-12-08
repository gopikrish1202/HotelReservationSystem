package com.client;

import java.util.List;
import java.util.Scanner;
import com.model.*;
import com.service.*;

public class UserInterface {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String continueChoice;
        RIResidentService RiR = new RIResidentService();
        NRIResidentService NRiR=new NRIResidentService();
        System.out.println("WELCOME TO HOTEL RESERVATION SYSTEM");
        System.out.println("--------------------------------------------------------");

        do {

            System.out.println("1.RIResident Customer(Resident Indian)");
            System.out.println("2.NRIResident Customer(NonResident Indian)");
            System.out.println("3.Manager");
            System.out.println("Enter the user Type:");
            int userType = sc.nextInt();

            switch (userType) {
                case 1:
                    System.out.println("1.Add RIResident Details");
                    System.out.println("2.Update RIResident Details");
                    System.out.println("3.Retrieve RIResident Details");
                    System.out.println("4. Delete RIResident Details");

                    System.out.println("Enter the choice:");
                    int choice = sc.nextInt();

                    if (choice == 1) {
                        System.out.println("Enter the number of RIResident customer details you want to add.");
                        int add = sc.nextInt();
                        sc.nextLine();
                        String[] input = new String[add];

                        System.out.println(
                                "Input must be-->Name :Age :Gender :Phonenumber :Email :Address :Number of Adults :Number Of Children Above12 :Number of Children Above5 :Duration Of Stay :Resident type :Aadhar No ");

                        for (int j = 0; j < add; j++) {
                            input[j] = sc.nextLine();
                        }

                        List<RIResident> result = RiR.addRiResidentDetails(input);

                        if (result.isEmpty()) {
                            System.out.println("Data are not added successfully");
                        } else {
                            for (RIResident i : result) {
                                System.out.println(i.getResidentName()
                                        + " RIResident is Added Successfully and your RIResident Id is: "
                                        + i.getResidentId());
                            }
                        }

                    } else if (choice == 2) {
                        System.out.println("1. Update the phone number\n2. Update Occupancy Details");
                        int choice1 = sc.nextInt();

                        switch (choice1) {

                            case 1:
                                System.out.println(
                                        "1. Update phone number using ResidentId\n2. Update phone number using idproof_ Aadhar no.\n3. Update phone number using existing contact number");
                                int choice11 = sc.nextInt();

                                switch (choice11) {
                                case 1:
                                    while (true) {
                                        System.out.println("Enter the Resident id");
                                        String rid = sc.next();
                                        boolean residentIdExists = RiR.checkIdExists(rid);
                                        if (!residentIdExists) {
                                            System.out.println("Resident Id not found. Please enter a valid Resident ID.");
                                        } else {
                                            System.out.println("Enter the new phone number");
                                            long contactNumber = sc.nextLong();
                                            int count = RiR.updateRIResidentPhoneNumberUsingResidentId(rid, contactNumber);
                                            if (count == 1) {
                                                System.out.println("Phone number updated successfully");
                                            } else {
                                                System.out.println("Update failed");
                                            }
                                            break; // exit the loop if the update is successful
                                        }
                                    }
                                    break;

                                    case 2:
                                        System.out.println("Enter the Aadhar number: ");
                                        long aad = sc.nextLong();
                                        System.out.println("Enter the new phone number");
                                        long contact_number = sc.nextLong();
                                        int count1 = RiR.updateRIResidentPhoneNumberUsingIdProof(aad,
                                                contact_number);
                                        if (count1 == 1) {
                                            System.out.println("Phone number updated successfully");
                                        } else {
                                            System.out.println("Update failed");
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Enter existing contact number: ");
                                        long old_con = sc.nextLong();
                                        System.out.println("Enter the new phone number");
                                        long new_contact_number = sc.nextLong();
                                        int count2 = RiR.updateRIResidentPhoneNumberUsingContactNumber(old_con,
                                                new_contact_number);
                                        if (count2 == 1) {
                                            System.out.println("Phone number updated successfully");
                                        } else {
                                            System.out.println("Update failed");
                                        }
                                        break;
                                }
                                break;

                            case 2:
                                System.out.println(
                                        "1.Update occupancy details using Resident Id\n2. Update occupancy using Aadhar ID proof\n3. Update occupancy using Contact number");
                                int choice12 = sc.nextInt();
                                switch (choice12) {
                                    case 1:
                                    	 while (true) {
                                    	        System.out.println("Enter the Resident id");
                                    	        String rid1 = sc.next();
                                    	        boolean residentIdExists1 = RiR.checkIdExists(rid1);
                                    	        if (!residentIdExists1) {
                                    	            System.out.println("Resident Id not found. Please enter a valid Resident ID.");
                                    	        } else {
                                    	            System.out.println("Enter updated number of adults");
                                    	            int adults_a = sc.nextInt();
                                    	            System.out.println("Enter updated number of children above 12 years");
                                    	            int child_12_a = sc.nextInt();
                                    	            System.out.println("Enter updated number of children above 5 years ");
                                    	            int child_5_a = sc.nextInt();
                                    	            int count3 = RiR.updateOccupancyUsingResidentId(adults_a, child_12_a, child_5_a, rid1);

                                    	            if (count3 == 1) {
                                    	                System.out.println("Occupancy details Updated successfully");
                                    	            } else {
                                    	                System.out.println("Update failed");
                                    	            }
                                    	            break; // exit the loop if the update is successful
                                    	        }
                                    	    }
                                    	    break;
                                    case 2:
                                        System.out.println("Enter the Aadhar id number");
                                        long aad1 = sc.nextLong();
                                        System.out.println("Enter updated number of adults");
                                        int adults_b = sc.nextInt();
                                        System.out.println("Enter updated number of children above 12 years");
                                        int child_12_b = sc.nextInt();
                                        System.out.println("Enter updated number of children above 5 years ");
                                        int child_5_b = sc.nextInt();
                                        int count4 = RiR.updateOccupancyUsingIdProof(adults_b, child_12_b,
                                                child_5_b, aad1);
                                        if (count4 == 1) {
                                            System.out.println("Occupancy details updated successfully");
                                        } else {
                                            System.out.println("Update failed");
                                        }
                                        break;

                                    case 3:
                                        System.out.println("Enter the contact number");
                                        long contact_number1 = sc.nextLong();
                                        System.out.println("Enter updated number of adults");
                                        int adults_c = sc.nextInt();
                                        System.out.println("Enter updated number of children above 12 years");
                                        int child_12_c = sc.nextInt();
                                        System.out.println("Enter updated number of children above 5 years ");
                                        int child_5_c = sc.nextInt();
                                        int count5 = RiR.updateOccupancyUsingContactNumber(adults_c, child_12_c,
                                                child_5_c, contact_number1);
                                        if (count5 == 1) {
                                            System.out.println("Occupancy details updated successfully");
                                        } else {
                                            System.out.println("Update failed");
                                        }
                                        break;
                                }
                                break;
                        }
                    } else if (choice == 3) {
                        System.out.println("Enter the Resident Id: ");
                        String id = sc.next();
                        List<RIResident> list = RiR.retrieveRIResidentDetails(id);
                        if (list.isEmpty()) {
                            System.out.println("Resident ID not found");
                        } else {
                            System.out.println(list);
                        }
                    } else if (choice == 4) {
                        System.out.println("Enter your ResidentId");
                        String del_res = sc.next();
                        int a = RiR.deleteRIResidentTable(del_res);

                        if (a == 1) {
                            System.out.println(
                                    "RIResident table with respective Resident ID has been deleted successfully");
                        } else {
                            System.out.println("Deletion was not successful");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid user type");
                    break;

                case 2:
                    System.out.println("1.Add NRIResident Details");
                    System.out.println("2.Update NRIResident Details");
                    System.out.println("3.Retrieve NRIResident Details");
                    System.out.println("4. Delete NRIResident Details");

                    System.out.println("Enter the choice:");
                    int choice2 = sc.nextInt();

                    if (choice2 == 1) {
                        System.out.println("Enter the number of NRIResident customer details you want to add.");
                        int add = sc.nextInt();
                        sc.nextLine();
                        String[] input = new String[add];

                        System.out.println(
                                "input must be-->Name :Age :Gender :Phonenumber :Email :Address :Number of Adults :Number Of Children Above12 :Number of Children Above5 :Duration Of Stay Resident Type :Passport Number :Passport Type: Nationality: Purpose For Visit:  ");

                        for (int j = 0; j < add; j++) {
                            input[j] = sc.nextLine();
                        }

                        List<NRIResident> result = NRiR.addNRiResidentDetails(input);

                        if (result.isEmpty()) {
                            System.out.println("Data are not added successfully");
                        } else {
                            for (NRIResident i : result) {
                                System.out.println(i.getResidentName()
                                        + " NRIResident is Added Successfully and your NRIResident Id is: "
                                        + i.getResidentId());
                            }
                        }

                    }
                    
                    
                    
                    
                    else if(choice2 == 2) {
                    	
                    	 System.out.println("1. Update the phone number\n2. Update Occupancy Details");
                    	 int choice21=sc.nextInt();
                    	 switch (choice21) {
                    	 
                    	
                         case 1:
                             System.out.println(
                                     "1. Update phone number using ResidentId\n2. Update phone number using passport no.\n3. Update phone number using existing contact number");
                             int choice211 = sc.nextInt();

                             switch (choice211) {
                             case 1:
                                 while (true) {
                                     System.out.println("Enter the Resident id");
                                     String rid = sc.next();
                                     boolean residentIdExists = NRiR.checkIdExists(rid);
                                     if (!residentIdExists) {
                                         System.out.println("Resident Id not found. Please enter a valid Resident ID.");
                                     } else {
                                         System.out.println("Enter the new phone number");
                                         long contactNumber = sc.nextLong();
                                         int count = NRiR.updateNRIResidentPhoneNumberUsingResidentId(rid, contactNumber);
                                         if (count == 1) {
                                             System.out.println("Phone number updated successfully");
                                         } else {
                                             System.out.println("Update failed");
                                         }
                                         break; // exit the loop if the update is successful
                                     }
                                 }
                                 break;
                                 
                                 
                                 

                                 case 2:
                                     System.out.println("Enter the Passport number: ");
                                     String pas = sc.next();
                                     System.out.println("Enter the new phone number");
                                     long contact_number = sc.nextLong();
                                     int count1 = NRiR.updateNRIResidentPhoneNumberUsingPassportNumber(pas,
                                             contact_number);
                                     if (count1 == 1) {
                                         System.out.println("Phone number updated successfully");
                                     } else {
                                         System.out.println("Update failed");
                                         System.out.println(count1);
                                     }
                                     break;

                                 case 3:
                                     System.out.println("Enter existing contact number: ");
                                     long old_con = sc.nextLong();
                                     System.out.println("Enter the new phone number");
                                     long new_contact_number = sc.nextLong();
                                     int count2 = NRiR.updateNRIResidentPhoneNumberUsingContactNumber(old_con,
                                             new_contact_number);
                                     if (count2 == 1) {
                                         System.out.println("Phone number updated successfully");
                                     } else {
                                         System.out.println("Update failed");
                                     }
                                     break;
                             }
                             break;
                             
                             
                             
                             
                    	
                         case 2:
                             System.out.println(
                                     "1.Update occupancy details using Resident Id\n2. Update occupancy using passport number\n3. Update occupancy using Contact number");
                             int choice12 = sc.nextInt();
                             switch (choice12) {
                             
                                 case 1:
                                 	 while (true) {
                                 	        System.out.println("Enter the Resident id");
                                 	        String rid1 = sc.next();
                                 	        boolean residentIdExists1 = NRiR.checkIdExists(rid1);
                                 	        if (!residentIdExists1) {
                                 	            System.out.println("Resident Id not found. Please enter a valid Resident ID.");
                                 	        } else {
                                 	            System.out.println("Enter updated number of adults");
                                 	            int adults_a = sc.nextInt();
                                 	            System.out.println("Enter updated number of children above 12 years");
                                 	            int child_12_a = sc.nextInt();
                                 	            System.out.println("Enter updated number of children above 5 years ");
                                 	            int child_5_a = sc.nextInt();
                                 	            int count3 = NRiR.updateOccupancyUsingResidentId(adults_a, child_12_a, child_5_a, rid1);

                                 	            if (count3 == 1) {
                                 	                System.out.println("Occupancy details Updated successfully");
                                 	            } else {
                                 	                System.out.println("Update failed");
                                 	            }
                                 	            break; // exit the loop if the update is successful
                                 	        }
                                 	    }
                                 	    break;
                                 	    
                                 	    
                                 	    
                                 	    
                                 case 2:
                                     System.out.println("Enter the Passport number");
                                     String pas = sc.next();
                                     System.out.println("Enter updated number of adults");
                                     int adults_b = sc.nextInt();
                                     System.out.println("Enter updated number of children above 12 years");
                                     int child_12_b = sc.nextInt();
                                     System.out.println("Enter updated number of children above 5 years ");
                                     int child_5_b = sc.nextInt();
                                     int count4 = NRiR.updateOccupancyUsingPassportNumber(adults_b, child_12_b,
                                             child_5_b, pas);
                                     if (count4 == 1) {
                                         System.out.println("Occupancy details updated successfully");
                                     } else {
                                         System.out.println("Update failed");
                                     }
                                     break;

                                     
                                     
                                 case 3:
                                     System.out.println("Enter the contact number");
                                     long contact_number1 = sc.nextLong();
                                     System.out.println("Enter updated number of adults");
                                     int adults_c = sc.nextInt();
                                     System.out.println("Enter updated number of children above 12 years");
                                     int child_12_c = sc.nextInt();
                                     System.out.println("Enter updated number of children above 5 years ");
                                     int child_5_c = sc.nextInt();
                                     int count5 = RiR.updateOccupancyUsingContactNumber(adults_c, child_12_c,
                                             child_5_c, contact_number1);
                                     if (count5 == 1) {
                                         System.out.println("Occupancy details updated successfully");
                                     } else {
                                         System.out.println("Update failed");
                                     }
                                     break;
                             }
                             break;
                     }
                        	 
                        	 
                        	
                        	 
                    }
                    
                    
                    else if(choice2 == 3) {
                    	System.out.println("Enter the Resident Id: ");
                        String id = sc.next();
                        List<NRIResident> list = NRiR.retrieveNRIResidentDetails(id);
                        if (list.isEmpty()) {
                            System.out.println("Resident ID not found");
                        } else {
                            System.out.println(list);
                        }
                    }
                    
                    
                    else if(choice2==4) {
                    
                    System.out.println("Enter your ResidentId");
                    String del_res = sc.next();
                    int a = NRiR.deleteNRIResidentTable(del_res);

                    if (a == 1) {
                        System.out.println(
                                "RIResident table with respective Resident ID has been deleted successfully");
                    } else {
                        System.out.println("Deletion was not successful");
                    }
                }
                break;
                    	 
                    

            }
                  
                    

            // Ask the user if they want to continue or exit
            System.out.println("Do you want to continue? (y/n): ");
            continueChoice = sc.next();

        } while (continueChoice.equalsIgnoreCase("y"));

        System.out.println("Thank you for using Hotel Reservation System, anytime at your service; Have a great day!");
    }
}
