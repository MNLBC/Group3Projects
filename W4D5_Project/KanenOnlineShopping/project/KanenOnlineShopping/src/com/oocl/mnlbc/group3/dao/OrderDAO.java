package com.oocl.mnlbc.group3.dao;

import java.util.List;

import com.oocl.mnlbc.group3.model.OrderBean;
import com.oocl.mnlbc.group3.model.ItemsBean;

public interface OrderDAO {
	
	public boolean createOrder(OrderBean cart);
	
	public boolean saveCart(ItemsBean items, int orderId);
	
	public  List<OrderBean> getTransactions(OrderBean cart);
	
	public List<ItemsBean> getItems(ItemsBean items);
	
	public int getOrderId();
}
