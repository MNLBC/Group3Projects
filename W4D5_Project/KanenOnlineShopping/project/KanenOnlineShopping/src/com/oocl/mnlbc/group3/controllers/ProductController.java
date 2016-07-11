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
import com.oocl.mnlbc.group3.dao.OrderDAO;
import com.oocl.mnlbc.group3.dao.OrderDAOImpl;
import com.oocl.mnlbc.group3.dao.ProductDAO;
import com.oocl.mnlbc.group3.dao.ProductDAOImpl;
import com.oocl.mnlbc.group3.model.CartBean;
import com.oocl.mnlbc.group3.model.CartItemBean;
import com.oocl.mnlbc.group3.model.OrderBean;
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
		} else if (method.equals("getItemsinCart")) {
			this.getItemsinCart(request, response);
		} else if (method.equals("checkoutCart")) {
			this.checkoutCart(request, response);
		} else if (method.equals("deleteProduct")) {
			this.deleteProduct(request, response);
		} else if (method.equals("updateProductQty")) {
			this.updateProductQty(request, response);
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
		if(session.getAttribute("itemCart") == null){
			session.setAttribute("itemCart", new CartBean());
		}
		//session.setAttribute("itemCart", new CartBean());

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
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		String imagePath = request.getParameter("imagePath");
		HttpSession session = request.getSession();

		CartBean itemCart = (CartBean) session.getAttribute("itemCart");

		boolean isItemAddedToCart = itemCart.addItemToCart(productId, productName, productDescription, productPrice,
				imagePath);
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

	public void getItemsinCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String returnJson = "{\"success\":true,\"data\":{\"itemsInCart\":[";
		HttpSession session = request.getSession();

		CartBean itemCart = (CartBean) session.getAttribute("itemCart");
		Gson gson = new Gson();
		for (CartItemBean item : itemCart.getItems()) {
			returnJson += gson.toJson(item) + ",";

		}
		returnJson = returnJson.substring(0, returnJson.length() - 1);
		returnJson += "] }}";

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnJson);
	}

	public void checkoutCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		//int userId = Integer.parseInt(request.getParameter("userid"));
		CartBean itemCart = (CartBean) session.getAttribute("itemCart");
		int userId= Integer.parseInt( session.getAttribute("userid").toString());
		OrderBean order = new OrderBean();
		// order.setUserId(userId);
		order.setUserId(userId);
		order.setOrderStatus("On Delivery");
		double totalCost = 0.00;
		for (CartItemBean item : itemCart.getItems()) {
			order.addItem(item);
			totalCost += item.getProductPrice();
		}
		order.setTotalCost(totalCost);

		OrderDAO orderDao = OrderDAOImpl.getInstance();
		orderDao.createOrder(order);
		
		this.clearCart(request, response);
		
		String returnJson = "{\"success\":true}";
		response.getWriter().write(returnJson);
		
	}

	public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String returnJson = "{\"success\":true}";
		HttpSession session = request.getSession();
		int productId = Integer.parseInt(request.getParameter("productId"));
		CartBean itemCart = (CartBean) session.getAttribute("itemCart");

		itemCart.removeItem(productId);

		session.setAttribute("itemCart", itemCart);
		response.getWriter().write(returnJson);

	}

	public void updateProductQty(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String returnJson = "{\"success\":true}";
		HttpSession session = request.getSession();
		String productsToUpdate = request.getParameter("productsToUpdate");
		CartBean itemCart = (CartBean) session.getAttribute("itemCart");

		String productArray[] = productsToUpdate.split("~");
		for (String product : productArray) {
			int productId = Integer.parseInt(product.split(",")[0].split(":")[1].replaceAll("txtQty", ""));
			System.out.println(String.valueOf(productId));
			int productQty = Integer.parseInt(product.split(",")[1].split(":")[1]);
			System.out.println(String.valueOf(productQty));

			itemCart.update(productId, productQty);

		}

		response.getWriter().write(returnJson);
	}

	
	public void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		//CartBean itemCart = (CartBean) session.getAttribute("itemCart");
		session.setAttribute("itemCart", null);
	}
}
