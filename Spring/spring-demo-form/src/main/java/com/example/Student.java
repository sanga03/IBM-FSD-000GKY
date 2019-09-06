package com.example;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Student {
private String name;
private String lname;
private LinkedHashMap<String, String> lc;
private String[] os;
private String country;
private String lang;
public LinkedHashMap<String, String> getLc() {
	return lc;
}
public void setLc(LinkedHashMap<String, String> lc) {
	this.lc = lc;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getLang() {
	return lang;
}
public String[] getOs() {
	return os;
}
public void setOs(String[] os) {
	this.os = os;
}
public void setLang(String lang) {
	this.lang = lang;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}

@Override
public String toString() {
	return "Student [name=" + name + ", lname=" + lname + ", lc=" + lc + ", os=" + Arrays.toString(os) + ", country="
			+ country + ", lang=" + lang + "]";
}
public Student() {

	lc= new LinkedHashMap<String, String>();
	lc.put("IN", "INDIA");
	lc.put("AUS", "AUSTRALIA");
	lc.put("US", "UNITED STATES");
	lc.put("UK", "UNITED KINGDOM");
	lc.put("GR", "GERMENY");
}

}
