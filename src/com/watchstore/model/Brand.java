package com.watchstore.model;

public class Brand {
	private int bid;
	private String name;
	private String photo;
	
	public Brand() {}
	
	public Brand(int bid, String name, String photo) {
		
		this.bid = bid;
		this.name = name;
		this.photo = photo;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
