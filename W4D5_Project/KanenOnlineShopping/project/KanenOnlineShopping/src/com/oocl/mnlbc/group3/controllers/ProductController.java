package com.oocl.mnlbc.group3.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oocl.mnlbc.group3.dao.ProductDAO;
import com.oocl.mnlbc.group3.dao.ProductDAOImpl;
import com.oocl.mnlbc.group3.model.CartBean;
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
			this.getProductList(request, response);
		} else if (method.equals("addProductToCart")) {
			this.addProductToCart(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void getProductList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String returnJson = "{\"success\":true,\"data\":{\"products\":[";

		List<ProductBean> products = productDAO.getProductList();

		/*
		 * //Sets the product list into the session HttpSession session =
		 * request.getSession(); ProductList prodList =
		 * ProductList.getInstance(); prodList.setProductList(products);
		 * session.setAttribute("prodList", prodList);
		 */
		HttpSession session = request.getSession();
		session.setAttribute("itemCart", new CartBean());

		Gson gson = new Gson();
		for (ProductBean product : products) {
			returnJson += gson.toJson(product) + ",";

		}

		returnJson = returnJson.substring(0, returnJson.length() - 1);
		returnJson += "]}}";

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnJson);

	}

	/**
	 * Adds an item to the shopping cart returns true if the item is added
	 * returns false if the item is already in cart and the quantity is just
	 * increased.
	 */
	private void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));

		HttpSession session = request.getSession();

		CartBean itemCart = (CartBean) session.getAttribute("itemCart");

		boolean isItemAddedToCart = itemCart.addItemToCart(productId, productPrice);
		session.setAttribute("itemCart", itemCart);

		String returnJson = "{\"success\":";

		if (isItemAddedToCart) {
			returnJson += "true";
		} else {
			returnJson += "false";
		}

		returnJson += "}";

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnJson);

	}

}
