package com.product;

public class Product {
	
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Product() {
		count +=1;
//		super();
	}
	public Product(int rate) {
//		super();
		this.rate = rate;
	}
	public int get_count() {
		return count;
	}
	int rate;
	
	static int count;
	static {
		count =0;
	}
	
}
