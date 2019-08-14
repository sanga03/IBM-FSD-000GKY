package com.InnerClass;

public class Main_Inner {
public static void main(String[] args) {
	Model md = new Model(12);
	Model.Rect rct= md.new Rect(32);
	System.out.println(rct.area());
	Model.Square sqr= md.new Square();
	System.out.println(sqr.area());
	
	System.out.println(args[1]);
	}

}
