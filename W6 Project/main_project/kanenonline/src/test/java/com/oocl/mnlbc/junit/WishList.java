/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.dao.WishListDAO;

/**
 * @author VERGAJO
 *
 */
public class WishList {
	
	private ApplicationContext applicationContext = null;
	private WishListDAO wishListDAO = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring-context.xml");
		wishListDAO = (WishListDAO) applicationContext.getBean("wishListDAO");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testClearUserWishList() {
		assertTrue(wishListDAO.clearUserWishList(1000000344));
	}
	
//	@Test
//	public void testSaveWishList() {
//		//fail("Not yet implemented");
//	}
//
	@Test
	public void testRemoveFromWishList() {
		assertTrue(wishListDAO.removeFromWishList(7000213));
	}
//	
//	@Test
//	public void testLoadUserWishList() {
//	//	fail("Not yet implemented");
//	}

}
