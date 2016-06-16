package com.w1d3;

import junit.framework.TestCase;

public class TestFactorial extends TestCase{

	
	public void testFactorial(){
		Factorial fact = new Factorial();
		assertEquals(362880,fact.factorial(9));
	}
	
}
