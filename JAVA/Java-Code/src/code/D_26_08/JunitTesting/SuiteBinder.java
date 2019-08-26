package code.D_26_08.JunitTesting;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

	
public class SuiteBinder extends TestCase {
	public static TestSuite createSuite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(new CalculatorTest());
		testSuite.addTest(new MyClassTest());
		return testSuite;
		
	}
	
public static void main(String[] args) {
	TestRunner.run(createSuite());
}
}
