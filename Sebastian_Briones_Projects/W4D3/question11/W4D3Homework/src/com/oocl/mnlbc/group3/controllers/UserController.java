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

/**
 * Servlet implementation class UserController for User Account related
 * operations
 * @author BRIONSE
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
		} else if (method.equals("validateLogin")) {
			this.validateLogin(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public synchronized void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String username = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String mobileNumber = request.getParameter("mobileNumber");
		String userRole = request.getParameter("userRole");
		String returnOutput = "";

		RequestDispatcher requestDispatcher =
			    request.getRequestDispatcher("/views/userexists.html");
		
		if (userDAO.userExists(username)) {
			//returnOutput = "<html><body><h2>Username is already in use by an existing account!</h2></body></html>";
			requestDispatcher.forward(request, response);
		} else {

			if (userDAO.registerUser(username, userPassword, fullName, email, address, mobileNumber, userRole)) {
				returnOutput = "<html><body><h2>You are now registered!</h2></body></html>";
			} else {
				returnOutput = "<html><body><h2>Failed to register your account!</h2></body></html>";
			}

		}

		response.getWriter().write(returnOutput);
	}

	public synchronized void validateLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String username = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");

		String returnOutput = "";

		if (userDAO.validateAccount(username, userPassword)) {
			returnOutput = "<html><body><h2>Welcome " + username + "!</h2></body></html>";
		} else {
			returnOutput = "<html><body><h2>Invalid username or password!</h2></body></html>";
		}
		response.getWriter().write(returnOutput);
	}
}
