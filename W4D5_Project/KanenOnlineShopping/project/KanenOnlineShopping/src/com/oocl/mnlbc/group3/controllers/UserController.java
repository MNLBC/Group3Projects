package com.oocl.mnlbc.group3.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oocl.mnlbc.group3.dao.UserDAO;
import com.oocl.mnlbc.group3.dao.UserDAOImpl;
import com.oocl.mnlbc.group3.model.CartBean;
import com.oocl.mnlbc.group3.model.UserBean;

/**
 * Servlet implementation class UserController for User Account related
 * operations
 * 
 * @author Group 3
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserDAO userDAO = UserDAOImpl.getInstance();

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		if (method.equals("registerUser")) {
			this.createUser(request, response);
		} else if (method.equals("loginUser")) {
			this.loginUser(request, response);
		} else if (method.equals("checkIfHasSession")) {
			this.checkIfHasSession(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void createUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		UserBean user = null;
		String username = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String deliveryAddress = request.getParameter("deliveryAddress");
		String mobileNumber = request.getParameter("mobileNumber");
		String userRole = "customer";

		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";
		user = new UserBean(0, username, userPassword, fullName, email, deliveryAddress, mobileNumber, userRole);

		if (userDAO.userExists(username)) {
			errorMsg += "usernametaken";
		}

		if (userDAO.emailExists(email)) {
			errorMsg += "emailtaken";
		}

		if (errorMsg.equals("")) {
			if (userDAO.registerUser(user)) {
				errorMsg += "none";
			} else {
				errorMsg += "failed";
			}

		}
		returnJson += errorMsg;
		returnJson += "\"}}";

		// returnJson += "\"messageKey\": \"register.user\",\"data\": {}}";

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnJson);
	}

	public void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		UserBean user = null;
		String username = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");

		String returnJson = "{\"success\":true,\"data\":{\"errormsg\":\"";
		String errorMsg = "";

		user = userDAO.validateAccount(username, userPassword);
		if (errorMsg.equals("")) {
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", user.getUserId());
				if(session.getAttribute("itemCart") == null){
					session.setAttribute("itemCart", new CartBean());
				}
				errorMsg += "none:" + user.getUserId();
			} else {
				errorMsg += "incorrectcredentials";
			}

		}
		returnJson += errorMsg;
		returnJson += "\"}}";

		// returnJson += "\"messageKey\": \"register.user\",\"data\": {}}";

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnJson);
	}

	public void checkIfHasSession(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String returnJson = "{\"userid\":";

		HttpSession session = request.getSession();
		if (session.getAttribute("userid") != null) {
			returnJson += "\"" +session.getAttribute("userid") + "\"";
		} else {
			returnJson += "\""+"nouser"+"\"";
		}
		returnJson += "}";
		response.getWriter().write(returnJson);
	}

}
