package com.oocl.mnlbc.Controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productDAO;

	@RequestMapping(value = "/productList", method = { RequestMethod.POST })
	@ResponseBody
	public String getProductList() throws IOException {
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		builder.append(returnJson);
		List<ProductBean> products = productDAO.getProductList();

	

		Gson gson = new Gson();
		for (ProductBean product : products) {
			returnJson += gson.toJson(product) + ",";

		}

		returnJson = returnJson.substring(0, returnJson.length() - 1);
		returnJson += "]}}";

		
		
		return returnJson;
		

	}

}
