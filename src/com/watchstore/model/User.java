package com.watchstore.model;

public class User {
	private int id;
	private String uname;
	private String email;
	private Address address;
	private String gender;
	private String password;
	private String type;
	private String photo;
	private String phone;
	
	public User() {}

	public User(int id, String uname, String email, Address address, String gender, String password, String type,
			String photo, String phone) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.password = password;
		this.type = type;
		this.photo = photo;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
