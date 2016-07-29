/**
 * 
 */
package com.oocl.mnlbc.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.OrderDAO;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.OrderItem;
import com.oocl.mnlbc.entity.UserMembershipAsn;

/**
 * @author Melvin Yu
 *
 *This is the Order DAO Implementation
 */
public class OrderDAOImpl implements OrderDAO {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	/**
	 * initialize the EntityManager & Factory
	 */
	public void init() {	
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();

	}

	/**
	 * @return List<Order>
	 * 
	 * this gets all the order transaction from the DB
	 */
	@Override
	public List<Order> getAllTransactions() {
		
		 Query query = entityManager.createQuery("select r from order r ");
			List<Order> result =  query.getResultList();
			return result;
	}
	
	/**
	 * @return List<OrderItem> 
	 * 
	 * this gets all the order items in the DB
	 */
	
	@Override
	public List<OrderItem> getAllItems() {
		
		 Query query = entityManager.createQuery("select r from OrderItem r ");
			List<OrderItem> result =  query.getResultList();
			return result;
	}

	/**
	 * @return Order
	 * @param order
	 * 
	 * this methods updated a certain order that was change its Status
	 */
	@Override
	public Order updateOrderStatus(Order order) {
		
		try{
		
		entityManager.getTransaction().begin();
		Order newOrder = entityManager.merge(order);
		entityManager.getTransaction().commit();
		return newOrder;
		}catch(Exception e){
			return null;
		}
		
		
	}

	/**
	 * @param orderId
	 * @return Order
	 * gets an order by order_id
	 */
	@Override
	public Order getOrderById(long orderId) {
		Order order =entityManager.find(Order.class, orderId);
		return order;
	}
	
	

}
