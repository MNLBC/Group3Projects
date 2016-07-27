/**
 * 
 */
package com.oocl.mnlbc.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.service.UpdateService;

import junit.framework.TestCase;

/**
 * @author Melvin Yu
 *
 */
public class UpdateServiceTest extends TestCase {

	private UpdateService updateService;
	private ApplicationContext applicationContext = null;
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-context.xml");
		updateService = (UpdateService) applicationContext.getBean("updateService");
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testServices(){
		
//		System.out.println(updateService.createUser("rehanameee", "redhat", "Melvin Yu", "yu_melvinrobert@yahoo.com", "laguna",
//				"1234567890", "Admin"));
		
		System.out.println(updateService.createProduct("Cherry Mobile", "Flare S4 Plus", 8000.00, 15, "resource/cherry.jpg"));
	}
	
	

}
