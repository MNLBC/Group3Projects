package com.oocl.mnlbc.group3.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oocl.mnlbc.group3.dao.ProductDAO;
import com.oocl.mnlbc.group3.dao.ProductDAOImpl;
import com.oocl.mnlbc.group3.model.ProductBean;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ProductDAO productDAO = ProductDAOImpl.getInstance();

	public ProductController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		if (method.equals("getProducts")) {
			this.getProducList(request, response);
		}

	}

	private void getProducList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String returnJson = "{\"success\":true,\"data\":{\"products\":[";

		List<ProductBean> products = productDAO.getProductList();
		Gson gson = new Gson();
		for (ProductBean product : products) {
			returnJson += gson.toJson(product) + ",";
			
		}
		
		returnJson = returnJson.substring(0, returnJson.length()-1);
		returnJson += "]}}";
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
