package com.example.client;

import com.example.MyDate;

public class Main_class {

	public static void main(String[] args) {
		
		MyDate mdate= new MyDate();
		mdate.createDate(20, 11, 2013);
		System.out.println(mdate.getDetails());
		if(mdate.setDay(21)) {
			System.out.println("set success");
		}else {
			System.out.println("date cannot be greater then 30");
		}
		if(mdate.setMonth(21)) {
			System.out.println("set success");
		}else {
			System.out.println("Month cannot be greater then 12");
		}
		if(mdate.setYear(2121)) {
			System.out.println("set success");
		}else {
			System.out.println("year cannot be greater then 1927");
		}
		
		System.out.println("Day:"+mdate.getDate()+"\tMonth:"+mdate.getMonth()+"\tYear"+mdate.getYear());
	}

}
