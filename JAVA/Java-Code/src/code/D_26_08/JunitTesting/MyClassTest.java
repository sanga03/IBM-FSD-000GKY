package code.D_26_08.JunitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class MyClassTest extends TestCase{

	@Test
	public void testMultiply() {
		assertEquals(100, new MyClass().multiply(5, 20));	
	}



}
