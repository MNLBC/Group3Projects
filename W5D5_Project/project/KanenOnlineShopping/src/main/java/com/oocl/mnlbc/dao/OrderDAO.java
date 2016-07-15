package com.oocl.mnlbc.dao;

import java.util.List;

import javax.activation.DataSource;

import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.OrderBean;

public interface OrderDAO {
	 /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	public void setDataSource(DataSource ds);
	
	public boolean createOrder(OrderBean cart);
	
	public boolean saveCart(CartItemBean items, long orderId);
	
	public  List<OrderBean> getTransactions(int userId);
	
	public List<ItemsBean> getItems(long orderId);
	
	public long getOrderId();
}
