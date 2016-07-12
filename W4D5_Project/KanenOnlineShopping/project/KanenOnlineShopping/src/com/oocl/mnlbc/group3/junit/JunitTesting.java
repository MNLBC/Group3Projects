/**
 * 
 */
package com.oocl.mnlbc.group3.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oocl.mnlbc.group3.dao.OrderDAO;
import com.oocl.mnlbc.group3.dao.OrderDAOImpl;
import com.oocl.mnlbc.group3.dao.UserDAO;
import com.oocl.mnlbc.group3.dao.UserDAOImpl;

/**
 * @author CUNTAAL
 * JUNIT Test for validation of users and email
 */
public class JunitTesting {

	private static UserDAO userDAO = UserDAOImpl.getInstance();
	private static OrderDAO orderDAO = OrderDAOImpl.getInstance();

	@Test
	public void testUserExists() {
		assertEquals(true, userDAO.userExists("brionse"));
		assertEquals(false, userDAO.userExists("admin"));
	}

	@Test
	public void testEmailExists() {
		assertEquals(true, userDAO.emailExists("baste@gmail.com"));
		assertEquals(false, userDAO.emailExists("alexis@gmail.com"));
		assertEquals(false, userDAO.emailExists("cm@gmail.com"));


	}
	
}
