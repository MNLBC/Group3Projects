
package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.ProductCommentAssn;

/**
 * Test saving product comment into database
 * @author FLOREJE
 *
 */
public class ProductCommentAssnTest {
	private ApplicationContext applicationContext = null;
	private ProductDAO productDAO = null;
	private UserDAO userDAO;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setup() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring-context.xml");
		productDAO = (ProductDAO) applicationContext.getBean("productDAO");
		userDAO = (UserDAO) applicationContext.getBean("userDAO");
	}


	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveProductComment() {
		ProductCommentAssn productCommentAssn = new ProductCommentAssn();
		
		productCommentAssn.setUserId(userDAO.findById(1000000323));
		productCommentAssn.setProductId(1999999917);
		productCommentAssn.setProductComment("Test Saving");
		//test if saving correct data would return true
		assertTrue(productDAO.saveProductComment(productCommentAssn.getUserId(), productCommentAssn.getProductId(), productCommentAssn.getProductComment()));
		
		productCommentAssn.setUserId(userDAO.findById(1000012345));
		productCommentAssn.setProductId(1999912345);
		productCommentAssn.setProductComment("Test Saving");
		//test if saving incorrect data would return false
		assertFalse(productDAO.saveProductComment(productCommentAssn.getUserId(), productCommentAssn.getProductId(), productCommentAssn.getProductComment()));
	}

}
