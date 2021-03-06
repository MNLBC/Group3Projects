package com.oocl.mnlbc.group3.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.mnlbc.group3.transaction.ChatTransaction;
/**
 * 
 * @author kanench
 *  JUNIT Testing for DAO
 */
public class Validations {

	@Test
	public void testCreateAccount() {
		ChatTransaction regTxn = new ChatTransaction();
		assertEquals(true,regTxn.createAccount("kanench12", "admin1234", "Christian Joel Kanen"));
	
	}

	@Test
	public void testCheckUsername() {
		ChatTransaction regTxn = new ChatTransaction();
		assertEquals(false,regTxn.checkUsername("admin"));
		assertEquals(true,regTxn.checkUsername("kanencch"));
	}

	@Test
	public void testValidate() {
		ChatTransaction regTxn = new ChatTransaction();
		assertEquals(false,regTxn.validate("kanen", "pogi"));
		assertEquals(false, regTxn.validate("brionse","1234123"));
		assertEquals(false,regTxn.validate("brionse", "123456"));
	}

}
