package register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mnlbc.dao.UserDAO;
import com.mnlbc.dao.UserDAOImp;
import com.mnlbc.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static UserDAO dao = UserDAOImp.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String firstname= request.getParameter("fname");
		String lastname= request.getParameter("lname");
		String password= request.getParameter("pass");
	
		User user = new User(email, username, firstname, lastname, password);
		
    	if(dao.checkIfUserExist(username)){
    		request.setAttribute("msg","User already Exist.<br>");
			RequestDispatcher rd = request.getRequestDispatcher("MainRegister.jsp");
			rd.forward(request, response);
		}
		if(email.equals("")|| username.equals("")||firstname.equals("")||lastname.equals("")||password.equals("")){
			request.setAttribute("msg","Please fill all fields.<br>");
			RequestDispatcher rd = request.getRequestDispatcher("MainRegister.jsp");
			rd.forward(request, response);
		} else {

		  dao.registerAccount(user);
		  RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
			
			}

		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
