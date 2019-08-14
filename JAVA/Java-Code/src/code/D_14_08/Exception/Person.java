package code.D_14_08.Exception;

import java.io.Serializable;

public class Person implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	String fname;
	String lname;

	public Person(String fname, String lname) {
//	super();
		this.fname = fname;
		this.lname = lname;
	}

	public Person() {
//	super();
	}

	public Person createPerson(String fname, String lname) throws Person_Exception {
		this.fname = fname;
		this.lname = lname;
		if (fname.charAt(0) != fname.toUpperCase().charAt(0) || lname.charAt(0) != lname.toUpperCase().charAt(0)) {
			throw new Person_Exception();
		} else
			return new Person(fname, lname);
	}

	public void display() {
		System.out.println("Person:" + fname + " " + lname);
		// TODO Auto-generated method stub

	}

	public boolean equalsPerson(Person p) throws PersonEqualsException {
//		Person p =(Person) obj;
//		System.out.println("name --- "+this.fname+" "+this.lname);
//		System.out.println("p++ name --- "+p.fname+" "+p.lname);
//		if(p.fname.contentEquals(this.fname)) {
//			System.out.println("saaammmmee");
//		}
		if (p.fname.contentEquals(this.fname) && p.lname.contentEquals(this.lname)) {
			System.out.println("Name Found");
			throw new PersonEqualsException();
		} else {

			System.out.println("Name not Found");
			return true;
		}

	}

}
