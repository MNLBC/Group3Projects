package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import com.oocl.mnlbc.group3.connection.DBConnection;
import com.oocl.mnlbc.group3.model.UserBean;

public class UserDAOImpl implements UserDAO {

	private final static UserDAOImpl userDAO = new UserDAOImpl();
	Connection conn;
	PreparedStatement pstmt;

	/**
	 * The constructor is set to private because there is no need to instantiate
	 * the Class every time. We only need one instance.
	 */
	private UserDAOImpl() {
		conn = DBConnection.getConnection();
	}

	/**
	 * returns the instance of the class.
	 * 
	 * @return UserDAOImpl
	 */
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
	public boolean validateAccount(String username, String password) {
		String sql = "SELECT 1 FROM USERS WHERE USERNAME ='" + username + "' AND USER_PASSWORD ='" + password + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLSyntaxErrorException se) {
			se.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean registerUser(UserBean user) {

		String username = user.getUserName();
		String userPassword = user.getUserPassword();
		String fullName = user.getFullName();
		String email = user.getEmail();
		String address = user.getAddress();
		String mobileNumber = user.getMobileNumber();
		String userRole = user.getUserRole();

		int i = 0;

		String sql = "INSERT INTO USERS(USERNAME,USER_PASSWORD,FULL_NAME,EMAIL,ADDRESS,MOBILE_NUMBER,USER_ROLE,USER_BALANCE) VALUES(?,?,?,?,?,?,?)";

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, fullName);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, mobileNumber);
			pstmt.setString(7, userRole);

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
