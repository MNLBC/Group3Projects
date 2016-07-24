package com.oocl.mnlbc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.CartDAO;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.model.ChangePasswordResult;
import com.oocl.mnlbc.model.ModelWrapper;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.model.UserWrapper;

/**
 * User Controller
 * 
 * @author VERGAJO
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
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
	public Response<UserWrapper<User>> loginUser(@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userPassword", required = true) String userPassword) throws Exception {
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

	/**
	 * This handles changing of user password
	 * 
	 * @param userId
	 * @param oldPassword
	 * @Param newPassword
	 * @return Response<ChangePasswordResult>
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePassword", method = { RequestMethod.POST })
	@ResponseBody
	public Response<ChangePasswordResult> changePassword(@RequestParam(value = "userId", required = true) long userId,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "oldPassword", required = true) String oldPassword,
			@RequestParam(value = "newPassword", required = true) String newPassword) throws Exception {

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

	/**
	 * This handles updating of user profile.
	 * 
	 * @param userId
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateProfile", method = { RequestMethod.POST })
	@ResponseBody
	public Response<User> updateProfile(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "fullName", required = true) String fullName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "mobileNumber", required = true) String mobileNumber) throws Exception {

		User user = userDAO.findById(Long.valueOf(userId));
		Response<User> response = new Response<User>();
		if (user != null) {

			user.setFullName(fullName);
			user.setEmail(email);
			user.setMobileNumber(mobileNumber);
			user.setAddress(address);

			if (userDAO.updateUser(user)) {
				user.setUserPassword("");
				response.setSuccess(true);
				response.setData(user);
			}

		}
		return response;

	}

}
