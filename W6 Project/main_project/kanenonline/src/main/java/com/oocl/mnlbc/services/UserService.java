package com.oocl.mnlbc.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.oocl.mnlbc.controllers.UserController;
import com.oocl.mnlbc.dao.CartDAO;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.model.ChangePasswordResult;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.model.UserWrapper;

/**
 * @author FLOREJE
 *
 */

public class UserService {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private static final Logger logger = Logger.getLogger(UserController.class);

	public String createUser(String userName, String userPassword, String fullName, String email,
			String deliveryAddress, String mobileNumber, String userRole) {

		logger.info(userName + " is trying to register");

		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		builder.append(returnJson);

		User user = new User(0, userName, userPassword, fullName, email, deliveryAddress, mobileNumber, userRole);
		if (userDAO.userExists(userName)) {
			errorMsg += "usernametaken";
			logger.info("Registration Failed, " + userName + " is already taken");
		}

		if (userDAO.emailExists(email)) {
			errorMsg += "emailtaken";
			logger.info("Registration Failed, " + email + " is already taken");
		}

		if (errorMsg.equals("")) {
			if (userDAO.registerUser(user)) {
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

	public Response<UserWrapper<User>> loginUser(String userName, String userPassword) {

		logger.info(userName + " is logging in..");

		UserWrapper<User> items = new UserWrapper<User>();
		User user = userDAO.validateAccount(userName, userPassword);
		items.getItems().add(user);

		Response<UserWrapper<User>> response = new Response<UserWrapper<User>>();

		if (user != null) {
			boolean userHasCart = cartDAO.findCartByUser(user.getUserId());
			items.setUserHasCart(userHasCart);
			response.setSuccess(true);
		}
		response.setData(items);
		return response;

	}

	public String logoutUser(){
		StringBuilder builder = new StringBuilder();
		String returnJson = "{\"success\":true}";
		builder.append(returnJson);
		logger.info("User has successfully logged out.");
		return returnJson;
	}
	
	public Response<ChangePasswordResult> changePassword(long userId, String userName,String oldPassword,String newPassword) throws Exception {

		User user = userDAO.validateAccount(userName, oldPassword);

		ChangePasswordResult chgPassResult = new ChangePasswordResult();

		if (user == null) {
			chgPassResult.setResult("Incorrect old password.");
		} else {
			if (userDAO.changePassword(user, newPassword)) {
				chgPassResult.setResult("Password successfully changed.");
			}
		}
		Response<ChangePasswordResult> response = new Response<ChangePasswordResult>();
		response.setData(chgPassResult);

		if (user != null) {
			response.setSuccess(true);
		}
		return response;

	}

}
