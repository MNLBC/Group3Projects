package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.Query;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;
/**
 * 
 * @author BRIONSE
 *
 */
public class ProductDAOImpl extends AbstractJPAGenericDAO<Product>implements ProductDAO {
	

	public ProductDAOImpl() {
		
	}

	@Override
	public List<Product> getProductList() {
		Query query = entityManager.createNativeQuery(
				"SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE, PRODUCT_STOCK_QUANTITY, PRODUCT_IMAGE_PATH  FROM PRODUCT",
				Product.class);
		return query.getResultList();

	}
	
}
