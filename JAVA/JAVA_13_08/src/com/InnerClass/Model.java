package com.InnerClass;

public class Model {
 public Model(int side) {
		super();
		this.side = side;
	}
 

public int getSide() {
	return side;
}

public void setSide(int side) {
	this.side = side;
}


int side;
 
	public class Rect {
		
			public Rect(int a_side) {
			super();
			this.a_side = a_side;
		}
			public Rect(int a_side,int sid) {
				super();
				this.a_side = a_side;
				side=sid;
			}
			
			private int a_side;
			public int area() {
				return a_side*side;
				
			}
	}
	
	public class Square{
		public Square(int a_side) {
			super();
			side = a_side;
		}
		public Square() {
			
		}
		public int area() {
			return side*side;
		}
	}
}
