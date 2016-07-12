package com.oocl.mnlbc.test;

import com.oocl.mnlbc.service.RegistrationService;

import junit.framework.TestCase;

public class RegistrationServiceTest extends TestCase {
	RegistrationService  rs = new RegistrationService(); 
	public void testTestingRegistration() {
		boolean testingRegister = rs.testingRegistration("jnflores", "qwerty", "Jerica Flores",  "09236109223", "jericaflores427@gmail.com"); 
 		assertTrue(testingRegister); 
	}

}
