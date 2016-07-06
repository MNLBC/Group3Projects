package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.conn.UserDaoIMPL;
import com.oocl.mnlbc.conn.UserDaoInterface;
import com.oocl.mnlbc.user.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/registration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDaoInterface dao = new UserDaoIMPL();
		User user = new User();
		user.setFullname(request.getParameter("fullname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));

		if (isUserExisting(user)) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>Registration</title></head>\n"
					+ "<body bgcolor=\"#fdf5e6\">\n" + "<h1>User is already existing.</h1>\n" + "</body></html>");
		} else {
			response.setContentType("text/html");
			PrintWriter out1 = response.getWriter();
			out1.println("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>Registration</title></head>\n"
					+ "<body bgcolor=\"#fdf5e6\">\n" + "<h1>You are now successfully registered.</h1>\n"
					+ "</body></html>");
			dao.addUser(user);
		}

	}

	private boolean isUserExisting(User users) {
		UserDaoIMPL check = new UserDaoIMPL();
		return check.isUserExisting(users);

	}

}
