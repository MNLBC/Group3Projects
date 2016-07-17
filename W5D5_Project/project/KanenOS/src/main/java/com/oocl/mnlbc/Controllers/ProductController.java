package com.oocl.mnlbc.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.model.ProductBean;
import com.oocl.mnlbc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/productList", method = { RequestMethod.GET })
	@ResponseBody
	public String getProductList() throws IOException {
		List<ProductBean> products = productService.getProductList();
		String returnJson = "";
		StringBuilder builder = new StringBuilder();
		if (products.isEmpty()) {

		} else {
			
			returnJson = "{\"success\":true,\"data\":{\"products\":[";
			builder.append(returnJson);

			Gson gson = new Gson();
			for (ProductBean product : products) {
				builder.append( gson.toJson(product) + ",");
              
			}

		}
         builder = new StringBuilder (builder.substring(0, builder.length() - 1));
	
		builder.append("]}}");

		return builder.toString();
	}

}
