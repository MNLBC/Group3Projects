package oocl.com.mnlbc.homeworkw4d3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oocl.com.mnlbc.homeworkw4d3.dao.UserDAO;
import oocl.com.mnlbc.homeworkw4d3.dao.UserDAOImpl;

/**
 * Servlet implementation class SaveToDBServlet
 */
@WebServlet("/SaveToDBServlet")
public class SaveToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO dao = UserDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveToDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username="";
		String userPassword=""; 
		String fullName="";
		String email="";
		String mobileNumber="";
		
		username=request.getParameter("uname");
		userPassword=request.getParameter("pass");
		fullName=request.getParameter("fname");
		email=request.getParameter("email");
		mobileNumber=request.getParameter("phone");
		
		if(request != null){
			if(!dao.userExists(username)){
				response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
			    out.println
			      ("<!DOCTYPE html>\n" +
			       "<html>\n" +
			       "<head><title>A Test FORM</title></head>\n" +
			       "<body style=\"background-color:skyblue; color:white\">\n" +
			       "<h1>USER ALREADY EXIST</h1>\n" +
			       "<a href=\"index.jsp\">Return to Registration page</a>"+
			       "</body></html>");
			}
			else{
				if(dao.registerUser(username, userPassword, fullName, email, mobileNumber)){
					response.setContentType("text/html");
				    PrintWriter out = response.getWriter();
				    out.println
				      ("<!DOCTYPE html>\n" +
				       "<html>\n" +
				       "<head><title>A Test FORM</title></head>\n" +
				       "<body style=\"background-color:skyblue; color:white\">\n" +
				       "<h1>USER CREATED</h1>\n" +
				       "<a href=\"index.jsp\">Return to Registration page</a>"+
				       "</body></html>");
				}else{
					response.setContentType("text/html");
				    PrintWriter out = response.getWriter();
				    out.println
				      ("<!DOCTYPE html>\n" +
				       "<html>\n" +
				       "<head><title>A Test FORM</title></head>\n" +
				       "<body style=\"background-color:skyblue; color:white\">\n" +
				       "<h1>FAILED TO CREATE USER</h1>\n" +
				       "<a href=\"index.jsp\" style=\"color:white\">Return to Registration page</a>"+
				       "</body></html>");
				    }
			}
		}
		
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
