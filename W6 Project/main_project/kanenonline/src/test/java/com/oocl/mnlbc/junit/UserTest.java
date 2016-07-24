package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.security.PasswordEncrypter;
import com.oocl.mnlbc.security.PasswordEncrypter.CannotPerformOperationException;

/**
 * 
 * Test Cases for UserDAOImpl
 * 
 * @author BRIONSE
 *
 */
public class UserTest {

	private ApplicationContext applicationContext = null;
	private UserDAO userDAO = null;

	@Before
	public void setup() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring-context.xml");
		userDAO = (UserDAO) applicationContext.getBean("userDAO");
	}

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test Register user
	 */
	@Test
	public void testUserRegistration() {
		String password = "redhat";
		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(password);
		} catch (CannotPerformOperationException e1) {
			e1.printStackTrace();
		}

		User newUser = new User(0, "brionse7654321", enryptedPassword, "Sebastian Briones", "brionse7654321@oocl.com",
				"Laguna", "09876543211", "Customer");
		assertTrue(userDAO.registerUser(newUser));

	}

	/**
	 * Test update user profile
	 */
	@Test
	public void testUpdateUserProfile() {
		User user = userDAO.findById(Long.valueOf("1000000194"));
		user.setFullName("Sebastian");
		user.setMobileNumber("09777773452");
		user.setAddress("Laguna 7777");
		user = userDAO.update(user);

	}

	/**
	 * Test correct login credentials
	 */
	@Test
	public void testCorrectAccountLogin() {
		assertTrue(userDAO.validateAccount("aicacute", "awe") != null);
	}

	/**
	 * Test incorrect login credentials
	 */
	@Test
	public void testIncorrectAccountLogin() {
		assertFalse(userDAO.validateAccount("aicacute", "fasdfasdfafs") != null);
	}

	/**
	 * Test checking of existing email
	 */
	@Test
	public void testEmailExists() {
		assertTrue(userDAO.emailExists("aicacute@oocl.com"));
	}

	/**
	 * Test checking of non-existent email
	 */
	@Test
	public void testEmailExistsForNonExistent() {
		assertFalse(userDAO.emailExists("aicacute321123@oocl.com"));
	}

}
