package com.Array;

public class Array_Builder {
private char arr[];

public Array_Builder() {
	
}
public Array_Builder(int ln) {
	arr = new char[ln];
}
public char[] build(char ch) {
	for(int i=0;i<arr.length;i++) {
		arr[i]=(char)(ch+i);
	}
	return arr;
}

}
