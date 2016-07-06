package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import com.oocl.mnlbc.group3.connection.DBConnection;
/**
 * 
 * UserDAO Implementation Class
 * Singleton Class
 * @author BRIONSE
 *
 */
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
				return true;
			} else {
				return false;
			}

		} catch (SQLSyntaxErrorException se) {
			se.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * Validates the username and password of the user logging in
	 */
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

	/**
	 * Registers the user Account Returns true if the account is successfully
	 * registered, else returns false. Also checks if the account is already
	 * existing.
	 */
	public boolean registerUser(String username, String userPassword, String fullName, String email, String address,
			String mobileNumber, String userRole) {

		int i = 0;
		double userBalance = 0.00;

		String sql = "INSERT INTO USERS(USERNAME, USER_PASSWORD, FULL_NAME, EMAIL, ADDRESS, MOBILE_NUMBER, USER_ROLE, USER_BALANCE) VALUES(?,?,?,?,?,?,?,?)";
		
		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, fullName);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.setString(6, mobileNumber);
			pstmt.setString(7, userRole);
			pstmt.setDouble(8, userBalance);

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
