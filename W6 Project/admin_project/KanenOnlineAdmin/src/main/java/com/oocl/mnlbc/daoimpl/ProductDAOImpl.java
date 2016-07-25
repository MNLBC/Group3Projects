/**
 * 
 */
package com.oocl.mnlbc.daoimpl;

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
 *This class is the Product DAO implementation of ProductDAO
 */
public class ProductDAOImpl implements ProductDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	/**
	 * initialize the EntityManager & Factory
	 */
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	/**
	 * @param id
	 * @return String
	 * this retrieves a product using a productId
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
