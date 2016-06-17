package com.oocl.mnlbc.group3.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.group3.util.Validators;

public class ValidatorsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckEmail() {
		Validators  validate = new Validators();
		assertEquals(true,validate.checkEmail("kanenpogi@gmail.com"));
		assertEquals(false,validate.checkEmail("kanenpogicom"));
	}

	
	@Test
	public void testCheckPhone() {
		Validators  validate = new Validators();
		assertEquals(true, validate.checkPhone("09236109223"));
		assertEquals(false, validate.checkPhone("hkjhkj"));
	}

}
