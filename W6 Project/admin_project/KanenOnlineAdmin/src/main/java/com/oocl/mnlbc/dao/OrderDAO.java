/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;

/**
 * @author Melvin Yu
 *
 */
public interface OrderDAO {

	public List<Order> getAllTransactions();

	public List<OrderItem> getAllItems();
	
	public Order updateOrderStatus(Order order);
	public Order getOrderById(long orderId);

}
