package com.oocl.mnlbc.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.ProductDAO;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.model.ProductList;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.services.ProductService;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * 
 * @author VERGAJO
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	private static final Logger logger = Logger.getLogger(ProductController.class);

	/**
	 * Retrieves the products
	 * 
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping(value = "/productList", method = { RequestMethod.POST })
	@ResponseBody
	public Response<ProductList> getProductList() throws IOException {

		Response<ProductList> response = new Response<ProductList>();

		response = productService.getProductList();

		return response;
	}

}
