package com.oocl.mnlbc.dao;

import java.util.List;
import com.oocl.mnlbc.entity.Product;

/**
 * Interface of Products
 * 
 * @author ITAGroup3
 *
 */
public interface ProductDAO extends GenericDAO<Product> {

	public List<Product> getProductList();

}