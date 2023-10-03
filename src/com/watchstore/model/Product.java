package com.watchstore.model;

public class Product {
	private int id;
	private String title;
	private String desc;
	private int price;
	private String photo;
	private int discount;
	private String type;
	private Brand brand;
	
	
	public Product() {}
	public Product(int id, String title, String desc,String photo, int price, int discount, String type, 
			 int stock,Brand brand) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.price = price;
		this.photo = photo;
		this.discount = discount;
		this.type = type;
		this.brand = brand;
	
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	private int stock;
}
