package com.app.dto.study;

public class ProductRequestForm {
	
	public String id;
	public String name;
	public int price;
	public String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProductRequestForm [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
	}
	
	
}
