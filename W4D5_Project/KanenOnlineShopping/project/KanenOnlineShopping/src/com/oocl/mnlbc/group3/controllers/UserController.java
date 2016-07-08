package com.oocl.mnlbc.group3.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.group3.dao.UserDAO;
import com.oocl.mnlbc.group3.dao.UserDAOImpl;
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
		
		
		String returnJson = "{\"success\":";

		user = new UserBean(0, username, userPassword, fullName, email, deliveryAddress, mobileNumber, userRole);

		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration.jsp");
		if (userDAO.userExists(username)) {
			//requestDispatcher.forward(request, response);
			returnJson += "false,\"messageKey\": \"register.user\",\"data\": {\"errormsg\": \"usernametaken\"}}";
		} else {
			if (userDAO.registerUser(user)) {
				returnJson += "true,\"messageKey\": \"register.user\",\"data\": {\"errormsg\": \"none\"}}";
			} else {
				returnJson += "false,\"messageKey\": \"register.user\",\"data\": {\"errormsg\": \"failed\"}}";
			}

		}

		//returnJson += "\"messageKey\": \"register.user\",\"data\": {}}";
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(returnJson);
	}

}
