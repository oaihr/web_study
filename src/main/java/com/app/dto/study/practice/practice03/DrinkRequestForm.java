package com.app.dto.study.practice.practice03;

public class DrinkRequestForm {
	String item;
	String type;
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "DrinkRequestForm [item=" + item + ", type=" + type + "]";
	}
	
	
}
