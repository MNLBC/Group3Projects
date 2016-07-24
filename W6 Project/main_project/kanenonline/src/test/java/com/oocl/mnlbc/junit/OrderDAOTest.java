package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.dao.OrderDAO;

/**
 * Test cases for OrderDAO
 * 
 * @author BRIONSE
 *
 */
public class OrderDAOTest {

	private ApplicationContext applicationContext = null;
	private OrderDAO orderDAO = null;

	@Before
	public void setup() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring-context.xml");
		orderDAO = (OrderDAO) applicationContext.getBean("orderDAO");
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetTransactions() {
		assertNotNull(orderDAO.getTransactions(1000000192L));
	}
}
