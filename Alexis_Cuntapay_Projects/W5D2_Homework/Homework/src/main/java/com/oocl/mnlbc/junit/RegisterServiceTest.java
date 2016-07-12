package com.oocl.mnlbc.junit;

import com.oocl.mnlbc.service.RegisterService;

import junit.framework.TestCase;

public class RegisterServiceTest extends TestCase {

	RegisterService service =  new RegisterService();
	public void testTesRegistrationSuccess() { 
				boolean testingRegister = service.testingRegistration("agcuntapay", "qwerty", "alexis@gmail.coom", "Laguna", "0912345678"); 
			assertTrue(testingRegister); 

}
}
