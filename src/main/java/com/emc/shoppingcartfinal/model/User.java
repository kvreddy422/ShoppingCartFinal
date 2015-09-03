package com.emc.shoppingcartfinal.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@Size(min=2,max=15 ,message="min 2 letter max 15 ")
	private String fname;
	private String lname;
	@NotNull(message=" mailId is mandatarory")
	private String emailId;
	
	private String addressLine2;
	@NotNull(message="City name can't we null")
	private String city;
	@NotNull(message="State name can't we null")
	private String state;
	@NotNull(message="Country name can't we null")
	private String country;
	@NotNull(message="Pincode name can't we null")
	private int pincode;
	
	private int roleID;
	
	@Size(min=6 , max=20 , message="minimum address required ; if exceed 20 units use addressLine2")
	private String addressLine1;
	
	@Size(min=5,max=25,message="Min 5 alphanumerics")
	private String password;
	

	
	
	public User() {
		
	}
	public User(String fname, String lname, String emailId, String addressLine1, String addressLine2, String city,
			String state, String country, int pincode, String password, int roleID) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.password = password;
		this.roleID = roleID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	
	

}
