package com.product;

public class Main_prod {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		Product p=null;
		p=new Product();
		System.out.println(p.get_count());
		p=new Book();
		System.out.println(p.get_count());
		p=new Electronics();
		System.out.println(p.get_count());
		p=new Tv();
		System.out.println(p.get_count());

	}

}
