package code.D_26_08.JunitTesting;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class CalculatorTest extends TestCase {
	public CalculatorTest(String name) {
		super(name);
	}
public CalculatorTest() {
	// TODO Auto-generated constructor stub
super();
}
	
	int x, y;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		x=100;
		y=20;

		System.out.println("Initial");

	
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		System.out.println("tear down");
		x = 0;
		y = 0;
	}
	@Test
	public void testAddMethod() {
//		System.out.println("hello");
		assertEquals(120, new Calculator(x, y).addMethod());
	}

	@Test
public	void testSubMethod() {
		assertEquals(x > y ? x - y : 1, new Calculator(x, y).subMethod());
	}



	public static void main(String[] args) {
//		TestRunner.run(CalculatorTest.class);
	
	}
}
