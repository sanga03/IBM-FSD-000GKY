package com.product;

public class Tv extends Electronics {
String company;

public Tv(int myear, String company) {
	super(myear);
	this.company = company;
}

public Tv(int myear) {
	super(myear);
}
public Tv() {
	super();
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}


}
