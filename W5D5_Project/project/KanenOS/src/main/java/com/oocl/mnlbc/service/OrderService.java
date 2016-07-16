/*package com.oocl.mnlbc.service;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.model.CartItemBean;

public class OrderService implements OrderDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private final static OrderService orderDAO = new OrderService();
	
	public static OrderService getInstance() {
		return orderDAO;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	@Override
	public boolean createOrder(OrderBean cart) {
	String userId = Integer.toString(cart.getUserId());
	//int userId = cart.getUserId();

	//String orderDate = cart.getOrderDate();
	String totalCost = Double.toString(cart.getTotalCost());
	//double totalCost = cart.getTotalCost();
	String orderStatus = cart.getOrderStatus();
	List<CartItemBean> items = cart.getItems();

	int i = 0;

	String sql = "Insert into ORDERS(" + "USER_ID," + "ORDER_DATE," + "TOTAL_COST," + "ORDER_STATUS) "
				+ "values(?,SYSDATE,?,?)";
	jdbcTemplateObject.update(sql,userId,totalCost,orderStatus,items);
		//i = pstmt.executeUpdate();

	if (!(i == 0)) {
		long orderId = getOrderId();

		for (CartItemBean item : items) {
			if (saveCart(item, orderId)) {
			} else {
				return false;
			}
		}

		return true;
	}
	return false;

}
	
	@Override
	public boolean saveCart(CartItemBean items, long orderId) {
		String id = Long.toString(orderId);
		String orderDate = Integer.toString(items.getProductId());
		String quantity = Integer.toString(items.getQuantity());
		String orderPrice = Double.toString(items.getProductPrice());

		int i = 0;

		String sql = "Insert into ORDER_ITEM(" + "ORDER_ID," + "PRODUCT_ID," + "QUANTITY," + "ORDERED_PRICE) "
				+ "values(?,?,?,?)";

		jdbcTemplateObject.update(sql,id,orderDate,quantity,orderPrice);
		if (!(i == 0)) {
			return true;
		}
		return false;

	}
}
*/