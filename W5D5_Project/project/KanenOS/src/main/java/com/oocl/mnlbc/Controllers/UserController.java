package com.oocl.mnlbc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	@ResponseBody
	public String createUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword,
			@RequestParam(value = "fullName", required = true) String fullName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "deliveryAddress", required = true) String deliveryAddress,
			@RequestParam(value = "mobileNumber", required = true) String mobileNumber,
			@RequestParam(value = "userRole", required = true) String userRole) throws Exception {

		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		builder.append(returnJson);

		System.out.println(userName);
		System.out.println(userPassword);
		System.out.println(email);
		System.out.println(fullName);
		System.out.println(deliveryAddress);
		System.out.println(mobileNumber);
		System.out.println(userRole);

		UserBean user = new UserBean(0, userName, userPassword, fullName, email, deliveryAddress, mobileNumber,
				userRole);
    System.out.println(user.getFullName());
		if (userService.userExists(userName)) {
			errorMsg += "usernametaken";
			System.out.println(errorMsg);
		}
		System.out.println(email);
		if (userService.emailExists(email)) {
			errorMsg += "emailtaken";
			System.out.println(errorMsg);
		}

		if (errorMsg.equals("")) {
			if (userService.registerUser(user)) {
				errorMsg += "none";
			} else {
				errorMsg += "failed";
			}
		}
	builder.append(errorMsg);

		builder.append("\"}}");
		System.out.println(builder.toString());
		return builder.toString();
	

	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	@ResponseBody
	public String loginUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword) throws Exception {

	
		
		UserBean user = userService.validateAccount(userName, userPassword);
		String returnJson = "";
		StringBuilder builder = new StringBuilder();
		if (user!=null) {
			returnJson = "{\"success\":true,\"data\":{\"user\":[";
			builder.append(returnJson);

			Gson gson = new Gson();
				builder.append( gson.toJson(user));

		} else {
			
			returnJson = "{\"success\":true,\"data\":{\"user\":[";
			builder.append(returnJson);
			Gson gson = new Gson();
			builder.append( gson.toJson(user));
		}
	
		builder.append("]}}");

		return builder.toString();

	}

	@RequestMapping(value = "/orders", method = { RequestMethod.POST })
	@ResponseBody
	public String getOrderList() throws Exception {
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"orders\":[";
		builder.append(returnJson);
		return returnJson;
	}

	@RequestMapping(value = "/session", method = { RequestMethod.POST })
	@ResponseBody
	public String checkIfHasSession() throws Exception {
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"userid\":";
		builder.append(returnJson);
		return returnJson;
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST })
	@ResponseBody
	public String logoutUser() throws Exception {
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true}";
		builder.append(returnJson);
		return returnJson;
	}
}
