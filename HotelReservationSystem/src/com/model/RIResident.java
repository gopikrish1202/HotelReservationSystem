package com.model;

public class RIResident extends Resident{
	
	
	private long idProofAadharNo;

	public long getIdProofAadharNo() {
		return idProofAadharNo;
	}


	public void setIdProofAadharNo(long idProofAadharNo) {
		this.idProofAadharNo = idProofAadharNo;
	}


	
	

	public RIResident(String residentId, String residentName, int age, String gender, long contactNumber, String email,
			String address, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5,
			int durationOfStay,String residentType,long idProofAadharNo) {
		super(residentId, residentName, age, gender, contactNumber, email, address, numberOfAdults, numberOfChildrenAbove12,
				numberOfChildrenAbove5, durationOfStay,residentType);
		this.idProofAadharNo=idProofAadharNo;
	}

	
	}

	


