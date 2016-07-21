package com.oocl.mnlbc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.oocl.mnlbc.Controllers.OrderController;
import com.oocl.mnlbc.Controllers.ProductController;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.model.ProductBean;
import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.service.OrderService;
import com.oocl.mnlbc.service.ProductService;
import com.oocl.mnlbc.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/servlet-contextt.xml" })
public class JUnitTesting {

	@Autowired
	private UserService userDAO;

	@Autowired
	private ProductService productDAO;

	@Autowired
	private OrderService orderDAO;

	@Test
	public void testSaveOrder() throws IOException {
		OrderController orderCtr = new OrderController();
		assertEquals(false, orderDAO.createOrder(new OrderBean()));
	}

	@Test
	public void testGetProductList() throws IOException {
		ProductController productCtr = new ProductController();
		//ProductService productDAO = productCtr.getProductService();
		String productsJson = productCtr.getProductList();

		List<ProductBean> products = productDAO.getProductList();
		assertNotNull(products);

	}

	@Test
	public void testGetBannedUsers() {
		assertNotNull(userDAO.getBannedUsers());
	}

	@Test
	public void testRegisterUser() {
		assertEquals(false, userDAO.registerUser(new UserBean()));
	}

	@Test
	public void validateAccount(String username, String password) {
		assertEquals(false, userDAO.validateAccount("brionse", "asdf"));
	}

	@Test
	public void testUserExists() {
		assertEquals(false, userDAO.userExists("brionse"));
		assertEquals(false, userDAO.userExists("alexx"));
	}

	@Test
	public void testEmailExists() {
		assertEquals(false, userDAO.emailExists("brionse999@oocl.com"));
	}

}
