/**
 * 
 */
package com.oocl.mnlbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.model.AllProduct;
import com.oocl.mnlbc.model.AllUser;
import com.oocl.mnlbc.model.Login;
import com.oocl.mnlbc.model.OrderAndItemList;
import com.oocl.mnlbc.model.UserRequestList;
import com.oocl.mnlbc.service.AdminService;

/**
 * @author Melvin Yu and Christian Kanen
 * 
 *
 *This class holds the admin controller
 *it handles our ajax request for displaying user request, all orders and userlogin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
/**
 * maps the request for retrieving the user request
 * @return UserRequestList
 */
	@RequestMapping(value = "/userRequest", method = RequestMethod.POST)
	@ResponseBody
	public UserRequestList getAllUserRequest() {
		
		UserRequestList response = new UserRequestList();
		response = adminService.getAllUserRequest();
		return response;
		
	}
	
	/**
	 * This methods handles the ajax of the Admin Login
	 * @param userName
	 * @param userPassword
	 * @return Login
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Login loginAdmin(String userName, String userPassword) {

		Login response = new Login();
		response = adminService.loginAdmin(userName, userPassword);
		return response;
		
	}

	/**
	 * this methods handles the retrieval of all orders to be displayed in the UI
	 * @return OrderAndItemList
	 */
	@RequestMapping(value = "/getOrders", method = RequestMethod.POST)
	@ResponseBody
	public OrderAndItemList getAllOrders() {
		OrderAndItemList orderList = adminService.getAllOrders();
		return orderList;
	}
	
	/**
	 * this methods handles the retrieval of all orders to be displayed in the UI
	 * @return OrderAndItemList
	 */
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST)
	@ResponseBody
	public AllUser getAllUsers() {
		AllUser allUser = adminService.retrieveAllUsers();
		return allUser;
	}
	
	/**
	 * this methods handles the retrieval of all orders to be displayed in the UI
	 * @return OrderAndItemList
	 */
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET)
	@ResponseBody
	public AllProduct getAllProducts() {
		AllProduct allProduct = adminService.retrieveAllProducts();
		return allProduct;
	}

}
