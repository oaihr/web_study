package com.app.dto.study.practice.practice06;

public class BodyInfoDTO {
	String name;
	int height;
	int weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "BodyInfoDTO [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
}
