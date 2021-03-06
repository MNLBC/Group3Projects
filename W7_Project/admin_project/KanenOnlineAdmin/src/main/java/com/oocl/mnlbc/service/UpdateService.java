/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.oocl.mnlbc.constants.KanenOnlineConstants;
import com.oocl.mnlbc.daoimpl.MembershipTypeDAOImpl;
import com.oocl.mnlbc.daoimpl.OrderDAOImpl;
import com.oocl.mnlbc.daoimpl.ProductDAOImpl;
import com.oocl.mnlbc.daoimpl.UserDAOImpl;
import com.oocl.mnlbc.daoimpl.UserMembershipAsnDAOImpl;
import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.Product;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.model.AllProduct;
import com.oocl.mnlbc.model.ProductList;
import com.oocl.mnlbc.model.UpdatedUsers;
import com.oocl.mnlbc.model.UserList;

/**
 * @author Melvin Yu
 * @author VERGAJO
 */
public class UpdateService {

	public UserMembershipAsn setApproval(String userId, String approvedType, String isApproved) {

		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.init();
		MembershipTypeDAOImpl memberService = new MembershipTypeDAOImpl();
		memberService.init();
		UserMembershipAsnDAOImpl userMemberAsnService = new UserMembershipAsnDAOImpl();
		userMemberAsnService.init();

		User user = userDAO.findById(Long.parseLong(userId));
		System.out.println(user);
		UserMembershipAsn memAsn = userMemberAsnService.findMembership(user);
		/*
		 * Default of isApproved is 0 -> 1 is Approved -> 2 is Disapproved
		 * Default of forApproval is 0 not to be displayed in Admin Ui -> 1 is a
		 * pending request to be displayed in the UI
		 * 
		 */
		if (user != null) {
			if (isApproved.equals("1")) {// if the value from the request param
											// isApprove is 1 it will approve
											// the user request.
				memAsn.setForApproval(0);
				memAsn.setRequestMembershipTypeId(0);// once approved the
														// requested type will
														// be back to 0
				memAsn.setMembershipTypeId(memberService.getIdByTypeName(approvedType));// and
																						// the
																						// current
																						// will
																						// be
																						// the
																						// requested
																						// type.
				memAsn.setRequestApproved(1);
			} else {
				memAsn.setForApproval(0);
				memAsn.setRequestApproved(2);
			}
			return memAsn = userMemberAsnService.updateMembership(memAsn);
		}
		return null;

	}

	public StringBuilder updateOrderStatus(String orderId, String status) {
		OrderDAOImpl orderDAO = new OrderDAOImpl();
		orderDAO.init();

		Order order = orderDAO.getOrderById(Long.parseLong(orderId));

		StringBuilder builder = new StringBuilder();
		String errorMsg = "";

		builder.append("{\"success\":true,\"data\":{\"errormsg\":\"");
		if (order != null) {
			order.setOrderStatus(status);
			order = orderDAO.updateOrderStatus(order);
			errorMsg += "none";

		} else {
			errorMsg += "failed";
		}

		builder.append(errorMsg);

		builder.append("\"}}");

		return builder;

	}

	public String updateUser(String jsonData) {

		MembershipTypeDAOImpl memDao = new MembershipTypeDAOImpl();
		memDao.init();
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.init();
		UserMembershipAsnDAOImpl userMemberAsnDAO = new UserMembershipAsnDAOImpl();
		userMemberAsnDAO.init();

		Gson gson = new Gson();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		UserList userList = gson.fromJson(jsonData, UserList.class);
		System.out.println(userList);
		UserMembershipAsn membership = new UserMembershipAsn();

		if (userList != null) {
			for (UpdatedUsers updatedUsers : userList.getUserList()) {
				User user = null;
				user = userDAO.findById(updatedUsers.getUserId());
				user.setUserRole(updatedUsers.getUserRole());
				user.setIsBlacklisted(updatedUsers.getIsBlacklisted());
				userDAO.updateUser(user);

				membership = userMemberAsnDAO.findMembership(user);
				membership.setMembershipTypeId(memDao.getIdByTypeName(updatedUsers.getMembershipType()));
				userMemberAsnDAO.updateMembership(membership);

			}

			errorMsg += "none";

		} else {
			errorMsg += "failed";
		}
		returnJson += errorMsg + "\"}}";
		return returnJson;
	}

	public String createUser(String userName, String userPassword, String fullName, String email,
			String deliveryAddress, String mobileNumber, String userRole) {
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.init();

		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		builder.append(returnJson);

		User user = new User(0, userName, userPassword, fullName, email, deliveryAddress, mobileNumber, userRole);
		UserMembershipAsn membership = new UserMembershipAsn();
		membership.setUserId(user);
		membership.setMembershipTypeId(KanenOnlineConstants.DEFAULT_USER_MEMBERSHIP_TYPE);
		user.setUserMembershipId(membership);
		if (userDAO.userExists(userName)) {
			errorMsg += "usernametaken";
		}

		if (userDAO.emailExists(email)) {
			errorMsg += "emailtaken";
		}

		if (errorMsg.equals("")) {
			if (userDAO.registerUser(user)) {
				errorMsg += "none";
			} else {
				errorMsg += "failed";
			}
		}
		builder.append(errorMsg);

		builder.append("\"}}");
		return builder.toString();

	}

	public String createProduct(String productName, String productDescription, double productPrice,
			int productStockQuantity, String productImagePath) {
		ProductDAOImpl productDAO = new ProductDAOImpl();
		productDAO.init();

		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		builder.append(returnJson);
		Product product = new Product(0, productName, productDescription, productPrice, productStockQuantity,
				productImagePath);

		if (productDAO.createProduct(product)) {
			errorMsg += "none";
		} else {
			errorMsg += "failed";
		}

		builder.append("\"}}");
		return builder.toString();
	}

	public AllProduct updateProduct(String jsonData) {

		Gson gson = new Gson();
		ProductList productList = gson.fromJson(jsonData, ProductList.class);
		System.out.println(productList);
		AllProduct response = new AllProduct();
		ProductDAOImpl productDAO = new ProductDAOImpl();
		List<Product> updatedProduct = new ArrayList<Product>();
		productDAO.init();
		if (productList != null) {
			for (Product product : productList.getProductList()) {
				updatedProduct.add(productDAO.updateProduct(product));
			}
			response.setProductList(updatedProduct);
			response.setSuccess(true);
		}
		return response;
	}
}
