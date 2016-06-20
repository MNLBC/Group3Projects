package com.oocl.mnlbc.factorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		Factorial app = new Factorial();
		assertEquals(120,app.factorial(5));
	}
}
