package com.oocl.mnlbc.mainspring;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.service.UserService;

@RestController
public class OrderItemController {

	@RequestMapping("/getItemById/{id}")
	public OrderItem getUserById(@PathVariable("id")int id) {
		UserService rs = new UserService();
		rs.init();
		EntityManager em = rs.getEntityManager();
		User userDb = rs.getUser(em, 100);
		OrderItem result = null;
		List<Order> orderList =  new ArrayList<Order>();
		 orderList = userDb.getOrderList();
		
		 for(Order order:orderList){
			 System.out.println(order);
		 }
		for(Order order : orderList){
			List<OrderItem> orderItemList = order.getItemList();
			for(OrderItem item : orderItemList){
				if(item.getItemId()==id){
					result=item;
				}
			}
		}
		return result;
	}
}
