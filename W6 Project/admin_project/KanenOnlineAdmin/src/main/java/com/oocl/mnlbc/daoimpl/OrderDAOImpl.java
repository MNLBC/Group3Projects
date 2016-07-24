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
 */
public class OrderDAOImpl implements OrderDAO {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {	
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.OrderDAO#getAllTransactions()
	 */
	@Override
	public List<Order> getAllTransactions() {
		
		 Query query = entityManager.createQuery("select r from order r ");
			List<Order> result =  query.getResultList();
			return result;
	}
	
	@Override
	public List<OrderItem> getAllItems() {
		
		 Query query = entityManager.createQuery("select r from OrderItem r ");
			List<OrderItem> result =  query.getResultList();
			return result;
	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.OrderDAO#updateOrderStatus()
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

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.OrderDAO#getOrderById(long)
	 */
	@Override
	public Order getOrderById(long orderId) {
		Order order =entityManager.find(Order.class, orderId);
		return order;
	}
	
	

}
