package oocl.com.mnlbc.homeworkw4d3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import oocl.com.mnlbc.homeworkw4d3.database.DBConnection;

public class UserDAOImpl implements UserDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	private final static UserDAOImpl userDAO = new UserDAOImpl();
	
	private UserDAOImpl() {
		conn = DBConnection.getConnection();
	}
	
	public static UserDAOImpl getInstance() {
		return userDAO;
	}


	@Override
	public boolean userExists(String username) {
		String sql = "SELECT 1 FROM USERS WHERE USERNAME ='" + username + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return false;
			}

		} catch (SQLSyntaxErrorException se) {
			System.out.println("User does not exist.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean registerUser(String username, String userPassword, String fullName, String email,
			String mobileNumber) {
		int i = 0;

		String sql = "INSERT INTO USERS(username,password,fullname,email,phone) VALUES(?,?,?,?,?)";

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);	
			pstmt.setString(1, username);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, fullName);
			pstmt.setString(4, email);
			pstmt.setString(5, mobileNumber);

			i = pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!(i == 0)) {
			return true;
		}
		return false;
	}

	

}
