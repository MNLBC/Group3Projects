package com.oocl.mnlbc.group3.dao;

import java.util.List;

import com.oocl.mnlbc.group3.model.CartBean;
import com.oocl.mnlbc.group3.model.ItemsBean;

public interface OrderDAO {
	
	public boolean createOrder(CartBean cart);
	
	public boolean saveCart(ItemsBean items, int orderId);
	
	public  List<CartBean> getTransactions(CartBean cart);
	
	public List<ItemsBean> getItems(ItemsBean items);
	
	public int getOrderId();
}
