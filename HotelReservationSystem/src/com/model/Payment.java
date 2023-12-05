package com.model;

public class Payment {
	private String payment_id;
	private String booking_id;
	private String resident_name;
	private String floor_number;
	private int check_in_date;
	private int check_out_date;
	private int payment_date;
	private String payment_method;
	private double bill_amount;
	
	public String getPaymentId() {
        return payment_id;
    }

    public void setPaymentId(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getBookingId() {
        return booking_id;
    }

    public void setBookingId(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getResidentName() {
        return resident_name;
    }

    public void setResidentName(String resident_name) {
        this.resident_name = resident_name;
    }

    public String getFloorNumber() {
        return floor_number;
    }

    public void setFloorNumber(String floor_number) {
        this.floor_number = floor_number;
    }

    public int getCheckInDate() {
        return check_in_date;
    }

    public void setCheckInDate(int check_in_date) {
        this.check_in_date = check_in_date;
    }

    public int getCheckOutDate() {
        return check_out_date;
    }

    public void setCheckOutDate(int check_out_date) {
        this.check_out_date = check_out_date;
    }

    public int getPaymentDate() {
        return payment_date;
    }

    public void setPaymentDate(int payment_date) {
        this.payment_date = payment_date;
    }

    public String getPaymentMethod() {
        return payment_method;
    }

    public void setPaymentMethod(String payment_method) {
        this.payment_method = payment_method;
    }

    public double getBillAmount() {
        return bill_amount;
    }

    public void setBillAmount(double bill_amount) {
        this.bill_amount = bill_amount;
    }
    
    public  Payment(String payment_id, String booking_id, String resident_name, String floor_number, int check_in_date, int check_out_date, int payment_date, String payment_method, double bill_amount) {
        this.payment_id = payment_id;
        this.booking_id = booking_id;
        this.resident_name = resident_name;
        this.floor_number = floor_number;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.bill_amount = bill_amount;
    }
	

}
