package com.Array;
import com.Array.Array_Builder;;
public class Main_Arr {

	public static void main(String[] args) {
		Array_Builder array_Builder = new Array_Builder(24,9);
		System.out.println(array_Builder.build('('));
		int arr[]={
			123,123,1,1,2,1,2,1,3,123,123,-123,13,123
		};
		arr =array_Builder.sortElement(arr);
		for(int a:arr){
			System.out.println(a);
		}

		if(array_Builder.pushItem(10)) System.out.println("Success"); else System.out.println("failure");;
		if(array_Builder.pushItem(120)) System.out.println("Success"); else System.out.println("failure");;
		if(array_Builder.pushItem(110)) System.out.println("Success"); else System.out.println("failure");;
		if(array_Builder.pushItem(102)) System.out.println("Success"); else System.out.println("failure");;
		
		if(array_Builder.popItem()>0) System.out.println("Success"); else System.out.println("failure");
		if(array_Builder.popItem()>0) System.out.println("Success"); else System.out.println("failure");
		if(array_Builder.popItem()>0) System.out.println("Success"); else System.out.println("failure");
		if(array_Builder.popItem()>0) System.out.println("Success"); else System.out.println("failure");
		if(array_Builder.popItem()>0) System.out.println("Success"); else System.out.println("failure");
			
	}

}
