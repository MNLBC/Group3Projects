package com.oocl.mnlbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/myFormAction")
public class LoginServlet extends HttpServlet {
	
	public static String user = "system";
	public static String password = "admin123";
	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String hostname = "localhost";
	public static String port = "1521";
	public static String sid = "xe";

	public static String URL = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + sid;
	public static Connection conn = null;
	static {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(URL, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		boolean success = false;
		String username = request.getParameter("uname");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String password = request.getParameter("pword");
		String cpassword = request.getParameter("cpword");
		String email = request.getParameter("email");

		try {
			success = AddUser(username, firstname, lastname, password, cpassword, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(success){
			out.println("<html>\n " + "<head> <title>Registration</title></head>\n" + "<h1>Account Successfully Created!</h1>" 
					+ "</body>\n" + "</html>");
		}else{
			out.println("<html>\n " + "<head> <title>Registration</title></head>\n" + "<h1>User Exist!</h1>" 
					+ "</body>\n" + "</html>");
		}
		

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// out.println(test());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public int test() {
		return 5;
	}

	

	public boolean AddUser(String username, String firstname, String lastname, String userpassword, String cpassword,
			String email) throws SQLException {

		PreparedStatement statement;
		Statement resultStatement =  conn.createStatement();
		ResultSet resultset;

		resultset = resultStatement.executeQuery("select * from ACCOUNT where username='"+username+ "'");
		boolean userExist = false;
		boolean validPassword = false;
		
		if (resultset.next()) {
				userExist = true;
		}
		
		if(userpassword.equals(cpassword)){
			validPassword = true;
		}else{
			//return "Password does not match!";
			return false;
		}

		String sql = "INSERT INTO ACCOUNT VALUES(?, ?, ?, ?, ?)";
		if (!userExist && validPassword) {
			try {
				statement = (PreparedStatement) conn.prepareStatement(sql);
				statement.setString(1, firstname);
				statement.setString(2, lastname);
				statement.setString(3, username);
				statement.setString(4, userpassword);
				statement.setString(5, email);
				statement.executeUpdate();

				statement.close();				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return false;
		}
		conn.close();
		return false;
	}

}
