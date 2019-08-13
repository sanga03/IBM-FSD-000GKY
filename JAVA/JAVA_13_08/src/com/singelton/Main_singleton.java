package com.singelton;

public class Main_singleton {

	public static void main(String[] args) {
		Messaging m = Messaging.getMessObj();
		System.out.println(m);
		System.out.println(m==Messaging.getMessObj());
		System.out.println(Messaging.getMessObj("Sanga"));
		System.out.println(Messaging.getMessObj("Sanga")==m);
	}

}
