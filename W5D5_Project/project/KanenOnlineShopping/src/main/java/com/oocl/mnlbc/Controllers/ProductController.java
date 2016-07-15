package com.oocl.mnlbc.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		

	}

}
