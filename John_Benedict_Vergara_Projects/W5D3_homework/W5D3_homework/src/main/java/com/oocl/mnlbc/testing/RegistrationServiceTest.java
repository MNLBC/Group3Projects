package com.oocl.mnlbc.testing;

import com.oocl.mnlbc.service.RegistrationService;

import junit.framework.TestCase;

public class RegistrationServiceTest extends TestCase {
	RegistrationService rs = new RegistrationService();

	public void testTestingRegistration() {
		boolean testingRegister = rs.testingRegistration("jaybeehehe", "lamorena30", "John Benedict", "Vergara",
				"09353775485", "jaybee@gmail.com");
		assertTrue(testingRegister);
	}

	public void testingPasswords() {
		boolean testingPasswords = rs.testingPasswords("lamorena30", "lamorena30");
		assertTrue(testingPasswords);
	}
}