package com.oocl.mnlbc.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;

/**
 * 
 * Test Retrieval of products
 * 
 * @author BRIONSE
 *
 */
public class ProductDAOTest {

	private ApplicationContext applicationContext = null;
	private ProductDAO productDAO = null;

	@Before
	public void setup() throws Exception {
		applicationContext = new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring-context.xml");
		productDAO = (ProductDAO) applicationContext.getBean("productDAO");
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetProducts() {
		List<Product> productList = productDAO.findAll();

		Product testProduct = new Product();
		testProduct.setProductId(2000000001);
		testProduct.setProductDescription("Mac Book Pro");
		testProduct.setProductName("Mac Book Pro");
		testProduct.setProductPrice(1000L);
		testProduct.setProductStockQuantity(10);
		testProduct.setImagePath("resource/macbook.jpg");

		assertNotNull(productDAO.findAll());
		assertEquals(testProduct.getProductId(), productList.get(0).getProductId());
		assertEquals(testProduct.getProductDescription(), productList.get(0).getProductDescription());
		assertEquals(testProduct.getImagePath(), productList.get(0).getImagePath());
		assertEquals(testProduct.getProductStockQuantity(), productList.get(0).getProductStockQuantity());
		assertEquals(testProduct.getProductPrice(), productList.get(0).getProductPrice());

	}

}
