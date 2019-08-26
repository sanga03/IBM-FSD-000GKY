package code.D_26_08.JunitTesting;

public class Calculator {
	private int x, y, result;

	public Calculator(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

public int addMethod() {
	return x+y;
}

public int subMethod() {
	return x-y;
}

}
