package com.oocl.mnlbc.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.print.Printer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oocl.mnlbc.dao.AccountDao;
import com.oocl.mnlbc.dao.AccountDaoImpl;

/**
 * Servlet implementation class threeParams
 */
@WebServlet("/threeParams")
public class threeParams extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountDaoImpl acctDao = AccountDaoImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public threeParams() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname").toString();
		String pword = request.getParameter("pword").toString();
		String fname = request.getParameter("fname").toString();
		String add = request.getParameter("add").toString();
		String cnt = request.getParameter("cnt").toString();
		String email = request.getParameter("email").toString();
		
		if (!acctDao.userExists(uname)) {
			out.write("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>"
					+ "Sample " + "</title></head>\n" + "<body>"
					+ "<h1>Username Existing " + "</h1><br>" + "</body></html>");
		}else if (acctDao.userRegister(uname, pword, fname, add, cnt, email)) {
			out.write("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>"
					+ "Sample " + "</title></head>\n" + "<body>"
					+ "<h1>SUCCESSFULLY REGISTERED!" + "</h1><br>" + "</body></html>");
		}else{
			out.write("<!DOCTYPE html>\n" + "<html>\n" + "<head><title>"
					+ "Sample " + "</title></head>\n" + "<body>"
					+ "<h1>CREATING ACCOUNT FAILED! " + "</h1><br>" + "</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
