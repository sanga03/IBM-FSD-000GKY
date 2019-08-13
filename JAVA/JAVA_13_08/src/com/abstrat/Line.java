package com.abstrat;

public class Line extends Model {
	
	int startPoint;
	int endPoint;
	public Line(int startPoint, int endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

	public Line() {
		super();
	}
	public int calculateLenth() {
		return getEndPoint()-getStartPoint();
	}

	@Override
	public boolean isGreater(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		Line m1 = (Line)obj1;
		Line m2 =(Line)obj2;
		return m1.calculateLenth()>m2.calculateLenth();
	}

	@Override
	public boolean isLess(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		Line m1 = (Line)obj1;
		Line m2 =(Line)obj2;
		return m1.calculateLenth()<m2.calculateLenth();
	}

	@Override
	public boolean isEqual(Object obj1, Object obj2) {
		Line m1 = (Line)obj1;
		Line m2 =(Line)obj2;
		return m1.calculateLenth()==m2.calculateLenth();
	}

}
