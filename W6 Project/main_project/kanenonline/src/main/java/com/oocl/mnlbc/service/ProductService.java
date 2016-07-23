package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;

public class ProductService implements ProductDAO {
	@PersistenceContext
	private EntityManagerFactory entityManagerFactory;
	private EntityManager em;

	public ProductService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
		em = entityManagerFactory.createEntityManager();
	}

	@Override
	public List<Product> getProductList() {
		Query query = em.createNativeQuery(
				"SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_STOCK_QUANTITY, PRODUCT_IMAGE_PATH  FROM PRODUCT",
				Product.class);
		return query.getResultList();

	}

	//sysout
}
