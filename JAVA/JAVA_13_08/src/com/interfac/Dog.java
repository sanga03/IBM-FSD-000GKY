package com.interfac;

public class Dog implements LivingThing {

	public void createLivingthing() {
		LivingThing l = new LivingThing() {
			
			@Override
			public void walk() {
				// TODO Auto-generated method stub
				System.out.println("Dog can walk to");
			}
		};
		l.walk();
	}
	
	@Override
	public void walk() {
		System.out.println("Dog can walk from interface");
	}
}
