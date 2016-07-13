package com.oocl.mnlbc.group3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.group3.model.User;
import com.oocl.mnlbc.group3.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userDAO;

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	@ResponseBody
	public String registerUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword,
			@RequestParam(value = "fullName", required = true) String fullName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "deliveryAddress", required = true) String deliveryAddress,
			@RequestParam(value = "mobileNumber", required = true) String mobileNumber) throws Exception {

		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";

		System.out.println(userName);
		System.out.println(userPassword);
		System.out.println(email);
		System.out.println(fullName);
		System.out.println(mobileNumber);
		System.out.println(deliveryAddress);
		
		User user = new User(userName, userPassword, fullName, email, deliveryAddress, mobileNumber, "customer");

		if (userDAO.userExists(userName)) {
			errorMsg += "usernametaken";
		}

		/*
		 * if (userDAO.emailExists(email)) { errorMsg += "emailtaken"; }
		 */

		if (errorMsg.equals("")) {
			if (userDAO.registerUser(user)) {
				errorMsg += "none";
			} else {
				errorMsg += "failed";
			}
		}
		returnJson += errorMsg;
		returnJson += "\"}}";

		return returnJson;

	}
}
