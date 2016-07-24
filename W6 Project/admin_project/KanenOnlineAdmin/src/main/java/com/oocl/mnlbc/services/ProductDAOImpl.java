/**
 * 
 */
package com.oocl.mnlbc.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.entity.User;

/**
 * @author Melvin Yu
 *
 */
public class ProductDAOImpl implements ProductDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.ProductDAO#getNameById(long)
	 */
	@Override

	public String getNameById(long id) {
		Query query = entityManager
				.createQuery("select r.productName from products r where r.productId = :id");
		query.setParameter("id", id);
		try {
			String result = (String) query.getSingleResult();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

}
