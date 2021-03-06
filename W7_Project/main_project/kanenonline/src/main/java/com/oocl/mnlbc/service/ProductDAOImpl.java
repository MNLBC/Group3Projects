package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.entity.ProductCommentAssn;
import com.oocl.mnlbc.entity.User;

/**
 * 
 * @author BRIONSE
 * @author FLOREJE
 */
public class ProductDAOImpl extends AbstractJPAGenericDAO<Product> implements ProductDAO {

	public ProductDAOImpl() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductList() {
		Query query = entityManager.createNativeQuery(
				"SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_STOCK_QUANTITY, PRODUCT_IMAGE_PATH  FROM PRODUCT",
				Product.class);
		List<Product> products = query.getResultList();
		for (Product product : products) {
			entityManager.refresh(product);
		}
		return products;

	}

	/**
	 * Saves the user's product comment to the database
	 * 
	 */
	@Override
	public boolean saveProductComment(User userId, long productId, String productComment) {

		ProductCommentAssn productCommentAssn = new ProductCommentAssn();
		productCommentAssn.setProductId(productId);
		productCommentAssn.setUserId(userId);
		productCommentAssn.setProductComment(productComment);

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(productCommentAssn);
			entityManager.getTransaction().commit();
			return true;

		} catch (PersistenceException e) {
			return false;
		}
	}

}
