package com.account;

public class Account {
	String name;
	int id;
	String location;

	public Account() {
		super();
	}

	public Account(String name, int id, String location) {
		super();
		this.name = name;
		this.id = id;
		this.location = location;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public boolean equals(Object obj) {
		Account ac= (Account)obj;
		if(ac.name==this.name && ac.id==this.id&& ac.location==this.location)
			return true;
		else
			return false;
		// TODO Auto-generated method stub
//		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account Details: \nName:"+name+"\nId:"+id+"\nLocation:"+location+"\n";
	}

}
