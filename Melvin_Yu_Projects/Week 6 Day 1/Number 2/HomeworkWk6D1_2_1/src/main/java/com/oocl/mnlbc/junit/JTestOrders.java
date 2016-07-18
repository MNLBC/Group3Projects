package com.oocl.mnlbc.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.UserService;

public class JTestOrders {

	@Test
	public void test() {
		UserService rs = new UserService();
		rs.init();
		EntityManager em = rs.getEntityManager();

		List<Order> orderList = new ArrayList<Order>();
		List<OrderItem> itemList = new ArrayList<OrderItem>();

		User user = new User(100, "SAM", "ITA", "11-21-1993");
			Order ord = new Order(101,user);
			OrderItem item = new OrderItem(102,"Asus Laptop","Laptop",ord);
			OrderItem item2 = new OrderItem(103,"Macbook Laptop","Laptop",ord);
			itemList.add(item);
			itemList.add(item2);
			ord.setItemList(itemList);
			orderList.add(ord);
		user.setOrderList(orderList);
		Integer test= new Integer(100);
		Integer id = rs.createUser(em, user);
		assertEquals(test, id);
		System.out.println("User - Order - Ordet Item Created");

		User userDb = rs.getUser(em, id);
		assertEquals(user,userDb);
		System.out.println("Retrieved User");


		rs.removeUser(em, userDb);
		System.out.println("Removed User");
		em.close();
	}

}
