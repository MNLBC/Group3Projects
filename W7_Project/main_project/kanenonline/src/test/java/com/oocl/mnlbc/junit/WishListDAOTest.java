/**
 * 
 */
package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertFalse;

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
public class WishListDAOTest {
	
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
		//will succeed if user has wishList
		//assertTrue(wishListDAO.clearUserWishList(1000000344L));
	}
	
	@Test
	public void testRemoveFromWishList() {
		//will succeed if the wishListId is existing
		//assertTrue(wishListDAO.removeFromWishList(7000245L));
		
		//will succeed if the wishListId is not existing
		assertFalse(wishListDAO.removeFromWishList(71231231));
	}
	
}
