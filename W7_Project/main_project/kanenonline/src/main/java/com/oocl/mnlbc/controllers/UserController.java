package com.oocl.mnlbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.model.ChangePasswordResult;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.model.UserWrapper;
import com.oocl.mnlbc.services.UserService;

/**
 * User Controller
 * 
 * @author FLOREJE
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserService userService;

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

		String builder = userService.createUser(userName, userPassword, fullName, email, deliveryAddress, mobileNumber,
				userRole);
		return builder;

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

		Response<UserWrapper<User>> response = new Response<UserWrapper<User>>();

		response = userService.loginUser(userName, userPassword);

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
	public String logoutUser(@RequestParam(value = "userId", required = true) String userId,
			@RequestParam(value = "userName", required = true) String userName) throws Exception {

		String returnJson = userService.logoutUser(userId, userName);
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

		Response<ChangePasswordResult> response = userService.changePassword(userId, userName, oldPassword,
				newPassword);
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

			if (userDAO.update(user) != null) {
				user.setUserPassword("");
				response.setSuccess(true);
				response.setData(user);
			}

		}
		return response;

	}
}
