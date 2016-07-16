package com.oocl.mnlbc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
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
		builder.append(errorMsg);

		System.out.println(userName);
		System.out.println(userPassword);
		System.out.println(email);
		System.out.println(fullName);
		System.out.println(deliveryAddress);
		System.out.println(mobileNumber);
		System.out.println(userRole);

		UserBean user = new UserBean(0, userName, userPassword, fullName, email, deliveryAddress, mobileNumber,
				userRole);

		if (userService.userExists(userName)) {
			errorMsg += "usernametaken";
		}
		if (userService.emailExists(email)) {
			errorMsg += "emailtaken";
		}

		if (errorMsg.equals("")) {
			if (userService.registerUser(user)) {
				errorMsg += "none";
			} else {
				errorMsg += "failed";
			}
		}
		returnJson += errorMsg;

		builder.append("\"}}");

		return returnJson;

	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	@ResponseBody
	public String loginUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword) throws Exception {

		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		builder.append(returnJson);
		builder.append(errorMsg);

		System.out.println(userName);
		System.out.println(userPassword);
		return returnJson;

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
