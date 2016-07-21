package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.model.ProductList;
import com.oocl.mnlbc.service.ProductService;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * 
 * @author ITAGroup3
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	private static final Logger logger = Logger.getLogger(ProductController.class);

	/**
	 * getting all the products
	 * 
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/productList", method = { RequestMethod.POST })
	@ResponseBody
	public ProductList getProductList() throws IOException {
		logger.info("Retrieving products from the database..");

		ProductList products = new ProductList();
		List<Product> productsList = productService.getProductList();

		products.setProducts(productsList);

		if (CollectionUtils.isNotEmptyList(productsList)) {
			logger.info("Products successfully retrieved.");
		} else {
			logger.info("Retrieval of products failed.");
		}

		return products;
	}

}
