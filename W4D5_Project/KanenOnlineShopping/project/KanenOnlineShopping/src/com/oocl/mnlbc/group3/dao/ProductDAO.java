package com.oocl.mnlbc.group3.dao;

import java.util.List;

import com.oocl.mnlbc.group3.model.ProductBean;

public interface ProductDAO {

	public List<ProductBean> getProductList();
	public boolean updateProductList(ProductBean prod);
	
}
