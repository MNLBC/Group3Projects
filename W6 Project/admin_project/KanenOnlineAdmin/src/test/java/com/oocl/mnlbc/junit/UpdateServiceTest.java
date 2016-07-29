/**
 * 
 */
package com.oocl.mnlbc.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.daoimpl.UserDAOImpl;
import com.oocl.mnlbc.daoimpl.UserMembershipAsnDAOImpl;
import com.oocl.mnlbc.service.UpdateService;

import junit.framework.TestCase;

/**
 * @author Melvin Yu
 *
 */
public class UpdateServiceTest extends TestCase {

	private UpdateService updateService;
	private ApplicationContext applicationContext = null;
	private UserDAOImpl userDAO = new UserDAOImpl();
	private UserMembershipAsnDAOImpl memberDAO = new UserMembershipAsnDAOImpl();
	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-context.xml");
		updateService = (UpdateService) applicationContext.getBean("updateService");
		userDAO.init();
		memberDAO.init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateAdminServices() {

		System.out.println(updateService.createUser("AQrehanameee111", "redhat", "Melvin Yu",
				"qwqweyu_melvinrobert111@yahoo.com", "laguna", "1234567890", "Admin"));

	}

	public void testProductServices() {

		System.out.println(
				updateService.createProduct("Cherry Mobile", "Flare S4 Plus", 8000.00, 15, "resource/cherry.jpg"));
	}

	public void testSetApproval() {
		
		assertEquals(memberDAO.findMembership(userDAO.findById(100000035L)), updateService.setApproval("1000000358", "VIP", "1"));
	}

}
