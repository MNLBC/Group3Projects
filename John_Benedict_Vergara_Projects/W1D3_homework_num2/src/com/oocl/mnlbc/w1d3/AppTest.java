package com.oocl.mnlbc.w1d3;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFactorial() {
		App_Factorial app = new App_Factorial();
		assertEquals(120, app.factorial(5));

	}

}
