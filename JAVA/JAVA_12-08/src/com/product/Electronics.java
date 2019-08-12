package com.product;

public class Electronics extends Product {
int myear;

public int getMyear() {
	return myear;
}

public void setMyear(int myear) {
	this.myear = myear;
}

public Electronics(int myear) {
	super();
	this.myear = myear;
}

public Electronics() {
	super();
}

}
