package com.app.dto.study.practice.practice04;

public class CategoryProductRequestForm {
	String category;
	String product;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "CategoryProductRequestForm [category=" + category + ", product=" + product + "]";
	}
	
	
}
