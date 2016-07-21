package com.oocl.mnlbc.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.model.CartItemBean;
import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.OrderBean;
/**
 * 
 * @author ITAGroup3
 *
 */
public class OrderService implements OrderDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private String cUserId;
	private String cTotalCost;
	private String cOrderStatus;
	private List<CartItemBean> cItems;

	private PlatformTransactionManager transactionManager;

	/**
	 * 
	 * @return PlatformTransactionManager
	 */
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	/**
	 * 
	 * @param transactionManager
	 */
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}


	/**
	 * This gets the datasource for the Database done by Autowired
	 */
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * Saving the order to the database using transaction block
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean createOrder(OrderBean cart) {
		TransactionTemplate tt = new TransactionTemplate(getTransactionManager());
		cUserId = Long.toString(cart.getUserId());

		cTotalCost = Double.toString(cart.getTotalCost());

		cItems = cart.getItems();
		boolean result = false;
		try {
			result = tt.execute(new TransactionCallback() {

				public Object doInTransaction(TransactionStatus status) {

					JdbcTemplate jt = new JdbcTemplate(dataSource);
					int i = 0;
					String sql = "Insert into ORDERS(" + "USER_ID," + "ORDER_DATE," + "TOTAL_COST," + "ORDER_STATUS) "
							+ "values(?,SYSDATE,?,?)";
					i = jt.update(sql, cUserId, cTotalCost, "On-Delivery");

					if (!(i == 0)) {
						long orderId = getOrderId();

						for (CartItemBean item : cItems) {
							if (saveCart(item, orderId)) {
							} else {
								return false;
							}
						}

						return true;
					}
					return false;
				}

			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
/**
 * this is the saving of items of a order to the database
 * @return boolean
 */
	@Override
	public boolean saveCart(CartItemBean items, long orderId) {
		String id = Long.toString(orderId);
		String orderDate = Integer.toString(items.getProductId());
		String quantity = Integer.toString(items.getQuantity());
		String orderPrice = Double.toString(items.getProductPrice());

		// int i = 0;

		String sql = "Insert into ORDER_ITEM(" + "ORDER_ID," + "PRODUCT_ID," + "QUANTITY,"
				+ "ORDERED_PRICE) " + "values(?,?,?,?)";
		try {
			jdbcTemplateObject.update(sql, id, orderDate, quantity, orderPrice);
			return true;
		} catch (DataAccessException de) {
			de.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// if (!(i == 0)) {
		// }
		return false;
	}

	/**
	 * this gets all the transactions of a certain user from the database
	 * @return List<OrderBean>
	 */
	@Override
	public List<OrderBean> getTransactions(long userId) {
		String sql = "SELECT * FROM ORDERS WHERE USER_ID='" + userId + "'";
		List<OrderBean> orderList = jdbcTemplateObject.query(sql, new OrderMapper());
		return orderList;
	}

	/**
	 * this gets all the items of a order 
	 * @return  List<CartItemBean>
	 */
	@Override
	public List<CartItemBean> getItems(long orderId) {
		String sql = "SELECT OI.ORDER_ID, P.PRODUCT_ID, P.PRODUCT_NAME, OI.QUANTITY, P.PRODUCT_DESCRIPTION, P.PRODUCT_PRICE FROM ORDER_ITEM OI INNER JOIN PRODUCT P ON P.PRODUCT_ID = OI.PRODUCT_ID WHERE OI.ORDER_ID =?";
		List<CartItemBean> itemList = jdbcTemplateObject.query(sql, new Object[] { orderId }, new OrderDetailsMapper());

		return itemList;

	}

	/**
	 * getting the Created OrderId so we can use it to persist the items using the Id
	 * @return Long
	 */
	@Override
	public long getOrderId() {
		String sql = "SELECT MAX(ORDER_ID) AS ORDER_ID FROM ORDERS";
		OrderBean orderId = jdbcTemplateObject.queryForObject(sql, new OrderIdMapper());

		return orderId.getOrderId();

	}
}
