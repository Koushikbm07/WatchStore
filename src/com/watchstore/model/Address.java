package com.watchstore.model;

public class Address {
	private String street;
	private String addressLine;
	private int pincode;
	private String city;
	private String state;
	private final String country="INDIA";
	private int uid;
	public Address( String street, String addressLine, int pincode, String city, String state, int uid) {
		this.street = street;
		this.addressLine = addressLine;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.uid = uid;
	}
	
	public Address() {}
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
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
	
}
