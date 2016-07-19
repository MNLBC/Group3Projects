package com.oocl.mnlbc.hw1no2.order;
/**
 * @author KANENCH
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

public class OrderUnitTest {

	@Test
	public void test() {

		OrderService rs = new OrderService();
		EntityManager em = rs.getEntityManager();

		List<Order> orders1 = new ArrayList<Order>();
		List<User> users1 = new ArrayList<User>();

		User user1 = new User(10003, "dequial", "animahope", "Aljun Dequilla", "Bacoor", "animahope@gmail.com");

		OrderItem orderItem1 = new OrderItem(20003, "Iphone 7", "New Iphone", 2000);
		OrderItem orderItem2 = new OrderItem(20004, "Asus Laptop", "I4 Laptop", 23000);
		OrderItem orderItem3 = new OrderItem(20005, "Oppo R7 PLUS", "4000mAh", 22950);
		Order order1 = new Order(user1.getUserId(), orderItem2.getItemId());
		Order order2 = new Order(user1.getUserId(), orderItem1.getItemId());
		Order order3 = new Order(user1.getUserId(), orderItem3.getItemId());

		orders1.add(order1);
		orders1.add(order2);
		orders1.add(order3);
		users1.add(user1);


		Integer test = new Integer(1);
		Integer id = rs.createUser(em, user1);
		assertEquals(test, id);
		System.out.println("Order Item Created");

		User userDb = rs.getUser(em, id);
		assertEquals(user1, userDb);
		System.out.println("Retrieved User");

		rs.removeUser(em, userDb);
		System.out.println("Removed User");
		em.close();
	}

}
