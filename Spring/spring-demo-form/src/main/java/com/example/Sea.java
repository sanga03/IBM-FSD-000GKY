package com.example;

import java.util.LinkedHashMap;

public class Sea {

	
	private String stype;
	private String sname;
	private LinkedHashMap<String, String> types;
	
	
	public Sea() {
		types= new LinkedHashMap<String, String>();
		types.put("NAME", "Name");
		types.put("Lang","Language");
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
