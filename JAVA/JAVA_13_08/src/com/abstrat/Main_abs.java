package com.abstrat;

public class Main_abs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flyer f=null;
		f= new Bird();
		f.flyoff();
	
	Model m = null;
	Model m2 = null;
	m = new Line(20,29);
	m2 = new Line(213,218);
	System.out.println(m.isGreater(m, m2));
	System.out.println(m.isLess(m, m2));
	System.out.println(m.isEqual(m, m2));
	
	}

}
