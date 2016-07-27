package com.oocl.mnlbc.dao;

import java.util.List;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.entity.ProductCommentAssn;

/**
 * Interface of Products
 * 
 * @author ITAGroup3
 *
 */
public interface ProductDAO extends GenericDAO<Product> {

	public List<Product> getProductList();
	public boolean saveProductComment (ProductCommentAssn productComment);

}