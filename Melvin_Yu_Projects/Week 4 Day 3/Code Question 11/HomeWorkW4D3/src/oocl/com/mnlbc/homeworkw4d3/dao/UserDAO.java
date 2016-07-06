package oocl.com.mnlbc.homeworkw4d3.dao;


public interface UserDAO {

	public boolean userExists(String username);
	
	public boolean registerUser(String username, String userPassword, String fullName, String email, String mobileNumber);
	
}
