package com.account;

public class Main_acc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac=new Account("sanga",23,"bang");
		Account new_ac=new Account("sanga",23,"bang");
		if(ac.equals(new_ac)) {
			System.out.println("Accounts are same");
		}else {
			System.out.println("Accounts are different");
		}
	}

}
