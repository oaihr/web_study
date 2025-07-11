package com.app.dto.study.practice.practice04;

public class StoreJewel {
	String store;
	String jewel;
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getJewel() {
		return jewel;
	}
	public void setJewel(String jewel) {
		this.jewel = jewel;
	}
	@Override
	public String toString() {
		return "StoreJewel [store=" + store + ", jewel=" + jewel + "]";
	}
	
}
