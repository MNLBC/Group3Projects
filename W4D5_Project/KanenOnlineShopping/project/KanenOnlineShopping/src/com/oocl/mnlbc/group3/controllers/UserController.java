package com.oocl.mnlbc.group3.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.group3.dao.UserDAO;
import com.oocl.mnlbc.group3.dao.UserDAOImpl;

/**
 * Servlet implementation class UserController
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

	public void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String mobileNumber = request.getParameter("mobileNumber");
		String userRole = request.getParameter("userRole");
		double userBalance = Double.parseDouble(request.getParameter("userBalance"));
		
		String returnJson = "{\"success\":";
		
		if(userDAO.registerUser(username, userPassword, fullName, email, address, mobileNumber, userRole, userBalance)){
			returnJson+="true";
		}else{
			returnJson+="false";
		}

		returnJson += "\"messageKey\": \"register.user\",\"data\": {}}";
		response.getWriter().write(returnJson);
	}

}
