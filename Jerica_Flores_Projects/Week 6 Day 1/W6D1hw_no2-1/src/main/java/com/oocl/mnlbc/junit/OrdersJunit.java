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

public class OrdersJunit {

	@Test
	public void test() {
		UserService rs = new UserService();
		rs.init();
		EntityManager em = rs.getEntityManager();

		List<Order> orderList = new ArrayList<Order>();
		List<OrderItem> itemList = new ArrayList<OrderItem>();

		User user = new User(1, "Ivan", "Macapagal", "12-30-2000");
			Order order = new Order(2,user);
			OrderItem item1 = new OrderItem(3,"Black Bag","Bag",order);
			OrderItem item2 = new OrderItem(4,"Floral Dress","Dress",order);
			itemList.add(item1);
			itemList.add(item2);
			order.setItemList(itemList);
			orderList.add(order);
		user.setOrderList(orderList);
		Integer test= new Integer(1);
		
		Integer id = rs.createUser(em, user);
		assertEquals(test, id);
		System.out.println("User, Order and Order item is created");

		User userDb = rs.getUser(em, id);
		assertEquals(user,userDb);
		System.out.println("User is retrieved");


		rs.removeUser(em, userDb);
		System.out.println("User is now removed");
		em.close();
	}

}
