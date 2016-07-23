package com.oocl.mnlbc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;

/**
 * User Controller
 * 
 * @author John Benedict Vergara
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userService;

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

		User user = new User(0, userName, userPassword, fullName, email, deliveryAddress, mobileNumber, userRole);
		if (userService.userExists(userName)) {
			errorMsg += "usernametaken";
			logger.info("Registration Failed, " + userName + " is already taken");
		}
		if (userService.emailExists(email)) {
			errorMsg += "emailtaken";
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
	public Response<ModelWrapper<User>> loginUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword) throws Exception {
		logger.info(userName + " is logging in..");

		ModelWrapper<User> items = new ModelWrapper<User>();
		User user = userService.validateAccount(userName, userPassword);
		items.getItems().add(user);

		Response<ModelWrapper<User>> response = new Response<ModelWrapper<User>>();
		response.setData(items);

		if (user != null) {
			response.setSuccess(true);
		}
		return response;

	}

	/**
	 * This handles the Logout
	 * 
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
