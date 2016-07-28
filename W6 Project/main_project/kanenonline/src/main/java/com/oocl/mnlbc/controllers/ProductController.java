package com.oocl.mnlbc.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.entity.ProductCommentAssn;
import com.oocl.mnlbc.model.ProductList;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.services.ProductCommentAssnService;
import com.oocl.mnlbc.services.ProductService;

/**
 * 
 * @author VERGAJO
 * @author FLOREJE
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCommentAssnService productCommentAssnService;

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
	
	@RequestMapping(value = "/saveProdComment", method = { RequestMethod.POST })
	@ResponseBody
	public String saveProductComment(@RequestParam(value = "userId", required = true) long userId, @RequestParam(value = "productId", required = true) long productId, 
						@RequestParam(value = "productComment", required = true) String productComment) throws IOException {
		
		String response = productCommentAssnService.saveProductComment(userId,productId,productComment);
		
		return response;
	}

}
