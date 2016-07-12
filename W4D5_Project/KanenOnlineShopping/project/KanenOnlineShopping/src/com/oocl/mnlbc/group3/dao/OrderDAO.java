package com.oocl.mnlbc.group3.dao;

import java.util.List;

import com.oocl.mnlbc.group3.model.OrderBean;
import com.oocl.mnlbc.group3.model.CartItemBean;
import com.oocl.mnlbc.group3.model.ItemsBean;

public interface OrderDAO {
	
	public boolean createOrder(OrderBean cart);
	
	public boolean saveCart(CartItemBean items, long orderId);
	
	public  List<OrderBean> getTransactions(int userId);
	
	public List<ItemsBean> getItems(long orderId);
	
	public long getOrderId();
}
