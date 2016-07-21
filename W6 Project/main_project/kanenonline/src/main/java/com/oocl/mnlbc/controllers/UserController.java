package com.oocl.mnlbc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.service.UserService;

/**
 * 
 * @author ITAGroup3
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = Logger.getLogger(UserController.class);

	/**
	 * This handles the registration in the UI
	 * 
	 * @param userName
	 * @param userPassword
	 * @param fullName
	 * @param email
	 * @param deliveryAddress
	 * @param mobileNumber
	 * @param userRole
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	@ResponseBody
	public String createUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword,
			@RequestParam(value = "fullName", required = true) String fullName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "deliveryAddress", required = true) String deliveryAddress,
			@RequestParam(value = "mobileNumber", required = true) String mobileNumber,
			@RequestParam(value = "userRole", required = true) String userRole) throws Exception {

		logger.info(userName + " is trying to register");

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
			logger.info("Registration Failed, " + userName + " is already taken");
		}
		System.out.println(email);
		if (userService.emailExists(email)) {
			errorMsg += "emailtaken";
			System.out.println(errorMsg);
			logger.info("Registration Failed, " + email + " is already taken");
		}

		if (errorMsg.equals("")) {
			if (userService.registerUser(user)) {
				errorMsg += "none";
				logger.info("User successfully registered");
			} else {
				errorMsg += "failed";
				logger.info("Registration failed");
			}
		}
		builder.append(errorMsg);

		builder.append("\"}}");
		System.out.println(builder.toString());
		return builder.toString();

	}

	/**
	 * This handles the login in the UI
	 * 
	 * @param userName
	 * @param userPassword
	 * @return String
	 * @throws Exception
	 */

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	@ResponseBody
	public String loginUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword) throws Exception {
		logger.info(userName + " is logging in..");

		UserBean user = userService.validateAccount(userName, userPassword);
		String returnJson = "";
		StringBuilder builder = new StringBuilder();
		if (user != null) {
			returnJson = "{\"success\":true,\"data\":{\"user\":[";
			builder.append(returnJson);

			Gson gson = new Gson();
			builder.append(gson.toJson(user));
			logger.info(userName + " has successfully logged in.");

		} else {

			returnJson = "{\"success\":true,\"data\":{\"user\":[";
			builder.append(returnJson);
			Gson gson = new Gson();
			builder.append(gson.toJson(user));
			logger.info(userName + " has failed to log in.");
		}

		builder.append("]}}");

		return builder.toString();

	}

	/**
	 * Session of the user
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/session", method = { RequestMethod.POST })
	@ResponseBody
	public String checkIfHasSession() throws Exception {
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"userid\":";
		builder.append(returnJson);
		return returnJson;
	}
	
	/**
	 * This handles the Logout
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/logout", method = { RequestMethod.POST })
	@ResponseBody
	public String logoutUser() throws Exception {
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true}";
		builder.append(returnJson);
		logger.info("User has successfully logged out.");
		return returnJson;
	}
}
