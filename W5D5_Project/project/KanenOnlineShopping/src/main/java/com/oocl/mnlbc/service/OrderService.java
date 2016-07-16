package com.oocl.mnlbc.service;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.model.OrderBean;
import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.ItemsBean;

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
	
	@Override
	public List<OrderBean> getTransactions(int userId) {
		//String userid= Integer.toString(userId);
		String sql = "SELECT * FROM ORDERS WHERE USER_ID=?";
	//	List<OrderBean> orderList = jdbcTemplateObject.query(sql, new OrderMapper());
		List<OrderBean> orderList= (List<OrderBean>) jdbcTemplateObject.queryForObject(sql, 
                 new Object[]{userId}, new OrderMapper());
		//List<OrderBean> orderList=new ArrayList<OrderBean>();
		if (!orderList.isEmpty()) {
			for (OrderBean order : orderList) {
				long orderId=order.getOrderId();
				userId= order.getUserId();
				String orderDate= order.getOrderDate();
				double total= order.getTotalCost();
				String status= order.getOrderStatus();
				orderList.add(new OrderBean(orderId,userId,orderDate,total,status,
						 null));
			}
				 
			}
		return orderList;
		}
	@Override
	public List<ItemsBean> getItems(long orderId) {
		String id= Long.toString(orderId);
		String sql = "SELECT * FROM ORDER_ITEM WHERE ORDER_ID=?";
		List<ItemsBean> itemList = (List<ItemsBean>) jdbcTemplateObject.queryForObject(sql, 
                new Object[]{orderId}, new ItemsMapper());
	//	List<ItemsBean> itemList=new ArrayList<ItemsBean>();
		if (!itemList.isEmpty()) {
			for (ItemsBean item : itemList) {
//				int orderItemId=Integer.parseInt( rs.getString("order_item_id"));
				int productId= item.getProductId();
				int quantity=item.getQuantity();
				double price= item.getItemPrice();
				itemList.add(new ItemsBean(orderId,productId,quantity,price));
			}
		}
		return itemList;
		
		
	}

	@Override
	public long getOrderId() {
		String sql = "SELECT MAX(ORDER_ID) AS ORDER_ID FROM ORDERS";
		List<OrderBean> orderList = jdbcTemplateObject.query(sql, new OrderMapper());
		long orderId = 0;
		if (!orderList.isEmpty()) {
			for (OrderBean order : orderList) {
				orderId=order.getOrderId();
			}
	}
		return orderId;
	
	}
}

