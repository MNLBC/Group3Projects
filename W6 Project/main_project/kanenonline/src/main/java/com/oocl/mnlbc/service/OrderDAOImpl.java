package com.oocl.mnlbc.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.model.CartItemBean;

/**
 * 
 * @author ITAGroup3
 *
 */
public class OrderDAOImpl implements OrderDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	private String cUserId;
	private String cTotalCost;
	private List<CartItemBean> cItems;

	public OrderDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * Saving the order to the database using transaction block
	 * 
	 * @return boolean
	 */
	@Override
	public boolean createOrder(Order order, List<OrderItem> orderItems) {
		try {

			entityManager.getTransaction().begin();

			entityManager.persist(order);

			entityManager.getTransaction().commit();

			entityManager.getTransaction().begin();
			for (OrderItem item : orderItems) {
				item.setOrderId(order);
				entityManager.persist(item);

			}
			entityManager.getTransaction().commit();

			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this is the saving of items of a order to the database
	 * 
	 * @return boolean
	 */
	public boolean saveCart(OrderItem items, long orderId) {
		// Query query = entityManager.createNativeQuery(
		// "INSERT INTO ORDER_ITEM(ORDER_ID, PRODUCT_ID, QUANTITY,
		// ORDERED_PRICE) VALUES(?,?,?,?)");

		long productId = items.getProductId();
		double quantity = items.getQuantity();
		double orderedPrice = items.getProductPrice();

		// query.setParameter(1, orderId);
		// query.setParameter(2, productId);
		// query.setParameter(3, quantity);
		// query.setParameter(4, orderedPrice);

		Order entityOrderId = entityManager.find(Order.class, orderId);

		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(entityOrderId);
		orderItem.setProductId(productId);
		orderItem.setQuantity(quantity);
		orderItem.setProductPrice(orderedPrice);

		try {

			entityManager.getTransaction().begin();
			entityManager.persist(orderItem);
			entityManager.getTransaction().commit();

			// query.executeUpdate();

			return true;
		} catch (PersistenceException e) {
			return false;
		}

	}

	/**
	 * this gets all the transactions of a certain user from the database
	 * 
	 * @return List<OrderBean>
	 */
	@Override
	public List<Order> getTransactions(long userId) {

		/*
		 * String sql = "SELECT * FROM ORDERS WHERE USER_ID='" + userId + "'";
		 * List<OrderBean> orderList = jdbcTemplateObject.query(sql, new
		 * OrderMapper()); return orderList;
		 */
		Query query = entityManager.createQuery("SELECT O FROM Order O WHERE O.userId = :userId");
		query.setParameter("userId", userId);
		List<Order> orderList = query.getResultList();

		return orderList;
	}

	/**
	 * this gets all the items of a order
	 * 
	 * @return List<CartItemBean>
	 */
	@Override
	public List<CartItemBean> getItems(long orderId) {
		/*
		 * String sql =
		 * "SELECT OI.ORDER_ID, P.PRODUCT_ID, P.PRODUCT_NAME, OI.QUANTITY, P.PRODUCT_DESCRIPTION, P.PRODUCT_PRICE FROM ORDER_ITEM OI INNER JOIN PRODUCT P ON P.PRODUCT_ID = OI.PRODUCT_ID WHERE OI.ORDER_ID =?"
		 * ; List<CartItemBean> itemList = jdbcTemplateObject.query(sql, new
		 * Object[] { orderId }, new OrderDetailsMapper());
		 * 
		 * return itemList;
		 */
		// Query query = entityManager.createQuery("SELECT O FROM OrderItem O
		// WHERE O.orderId = :orderId");
		Query query = entityManager.createNativeQuery(
				"SELECT OI.ORDER_ID, P.PRODUCT_ID, P.PRODUCT_NAME, OI.QUANTITY, P.PRODUCT_DESCRIPTION, P.PRODUCT_PRICE, P.PRODUCT_IMAGE_PATH FROM ORDER_ITEM OI INNER JOIN PRODUCT P ON P.PRODUCT_ID = OI.PRODUCT_ID WHERE OI.ORDER_ID =?");
		query.setParameter(1, orderId);
		// query.setParameter("orderId", order);
		System.out.println(query.getResultList());
		List<CartItemBean> orderItems = query.getResultList();

		return orderItems;
	}

	/**
	 * getting the Created OrderId so we can use it to persist the items using
	 * the Id
	 * 
	 * @return Long
	 */
	@Override
	public long getOrderId() {
		/*
		 * String sql = "SELECT MAX(ORDER_ID) AS ORDER_ID FROM ORDERS";
		 * OrderBean orderId = jdbcTemplateObject.queryForObject(sql, new
		 * OrderIdMapper());
		 * 
		 * return orderId.getOrderId();
		 */
		return 1;

	}

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub

	}

}
