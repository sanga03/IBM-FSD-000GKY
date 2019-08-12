package com.example;

public class MyDate {

	private int day;
	private int month;
	private int year;
	
	public void createDate(int d,int m,int y) {
		if(d>30) {
			System.out.println("Day cant be greter then 30");
			System.exit(0);
		}else {
			System.out.println("good to go");
		}
		if(m>12) {
			System.out.println("Month cant be greter then 12");
			System.exit(0);
		}else {
			System.out.println("good to go");
		}
		if(y<1930) {
			System.out.println("year cant be less then 1930");
			System.exit(0);
		}else {
			System.out.println("good to go");
		}
		
		day=d;
		month=m;
		year=y;
	}
	
	public int getDate() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public boolean setDay(int d) {
		if(d>30) return false;
		day=d;
		return true;
	}
	public boolean setMonth(int m) {
		if(m>12) return false;
		month=m;
		return true;
	}
	public boolean setYear(int y) {
		if(y>1937) return false;
		year=y;
		return true;
	}
	
	public String getDetails() {
		return day+"/"+month+"/"+year;
		
	}
	
}
