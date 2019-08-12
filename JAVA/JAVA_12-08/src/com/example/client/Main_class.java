package com.example.client;

import com.example.MyDate;

public class Main_class {

	public static void main(String[] args) {
		MyDate mdate= new MyDate();
		mdate.createDate(20, 121, 2013);
		System.out.println(mdate.getDetails());
	}

}
