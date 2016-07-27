/**
 * 
 */
package com.oocl.mnlbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.model.Login;
import com.oocl.mnlbc.model.OrderAndItemList;
import com.oocl.mnlbc.model.UserRequestList;
import com.oocl.mnlbc.service.AdminService;

/**
 * @author Melvin Yu
 * 
 *
 *This class holds the admin controller
 *it handles our ajax request for displaying user request, all orders and userlogin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
/**
 * maps the request for retrieving the user request
 * @return UserRequestList
 */
	@RequestMapping(value = "/userRequest", method = RequestMethod.POST)
	@ResponseBody
	public UserRequestList getAllUserRequest() {
		AdminService adminService = new AdminService();
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
		AdminService adminService = new AdminService();
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
		AdminService adminService = new AdminService();
		OrderAndItemList orderList = adminService.getAllOrders();
		return orderList;
	}

}
