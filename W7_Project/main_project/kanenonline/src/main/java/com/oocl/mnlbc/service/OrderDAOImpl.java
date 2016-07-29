package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.model.CartItemBean;

/**
 * 
 * @author VERGAJO
 *
 */
public class OrderDAOImpl extends AbstractJPAGenericDAO<Order> implements OrderDAO {

	public OrderDAOImpl() {

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
	 * This saves the items of an order to the database
	 * 
	 * @return boolean
	 */
	public boolean saveCart(OrderItem items, long orderId) {

		// save the orderItem to the database
		long productId = items.getProductId();
		int quantity = items.getQuantity();
		double orderedPrice = items.getProductPrice();

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
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getTransactions(long userId) {
		// gets the Order of the certain user using the userId
		if (userId > 0) {
			Query query = entityManager.createQuery("SELECT O FROM Order O WHERE O.userId = :userId");
			query.setParameter("userId", userId);
			try {
				List<Order> orderList = query.getResultList();
				for(Order order: orderList){
					entityManager.refresh(order);
				}
				return orderList;
			} catch (PersistenceException e) {
				return null;
			}

		}
		return null;

	}

	/**
	 * This gets all the items of a order
	 * 
	 * @return List<CartItemBean>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CartItemBean> getItems(long orderId) {
		// retrieves the data from database joining the product and order table
		// on the productId field
		Query query = entityManager.createNativeQuery(
				"SELECT OI.ORDER_ID, P.PRODUCT_ID, P.PRODUCT_NAME, OI.QUANTITY, P.PRODUCT_DESCRIPTION, P.PRODUCT_PRICE, P.PRODUCT_IMAGE_PATH FROM ORDER_ITEM OI INNER JOIN PRODUCT P ON P.PRODUCT_ID = OI.PRODUCT_ID WHERE OI.ORDER_ID =?");
		query.setParameter(1, orderId);
		List<CartItemBean> orderItems = query.getResultList();

		return orderItems;
	}

}
