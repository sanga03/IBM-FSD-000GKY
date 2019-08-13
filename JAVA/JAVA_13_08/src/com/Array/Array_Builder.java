package com.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Array_Builder {
private char arr[];
Stack<Integer> stk ;
int len;
public Array_Builder() {
	stk = new Stack<Integer>();
}
public Array_Builder(int ln,int len) {
	stk = new Stack<Integer>();
	arr = new char[ln];
	this.len =len;
	

}
public char[] build(char ch) {
	for(int i=0;i<arr.length;i++) {
		arr[i]=(char)(ch+i);
	}
	return arr;
}
public int[] sortElement(int[] arr){
	Arrays.sort(arr);
	return arr;
}
public int findElement(int[] arr,int item){
	return (Arrays.binarySearch(arr, item));
}
public boolean pushItem(int item){
	if(stk.size() > len){
		System.out.println("Over flow");
		return false;
	}
	else
	stk.push(item);
	return true;
}
public int popItem(){
	if(stk.size() < 1){
		System.out.println("Under flow");
		return -1;
	}
	return stk.pop();
}

}
