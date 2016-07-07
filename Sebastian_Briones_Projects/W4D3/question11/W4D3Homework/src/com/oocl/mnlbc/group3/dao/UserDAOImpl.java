package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import com.oocl.mnlbc.group3.connection.DBConnection;
import com.oocl.mnlbc.group3.security.PasswordEncrypter;
import com.oocl.mnlbc.group3.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.group3.security.PasswordEncrypter.InvalidHashException;

/**
 * 
 * UserDAO Implementation Class 
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
	 * Validates the username, hashes the password provided and compares the two
	 * hashes if they are the same. Uses Thornby's implementation of Java PBKDF2
	 * - using javax.crypto.SecretKeyFactory;
	 */
	@Override
	public boolean validateAccount(String username, String password) {
		String sql = "SELECT USER_PASSWORD FROM USERS WHERE USERNAME ='" + username + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String passwordHash = rs.getString(1);
				try {
					if (PasswordEncrypter.verifyPassword(password, passwordHash)) {
						return true;
					}
				} catch (CannotPerformOperationException e) {
					e.printStackTrace();
				} catch (InvalidHashException e) {
					e.printStackTrace();
				}
				return false;

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

		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(userPassword);
		} catch (CannotPerformOperationException e1) {
			e1.printStackTrace();
		}

		String sql = "INSERT INTO USERS(USERNAME, USER_PASSWORD, FULL_NAME, EMAIL, ADDRESS, MOBILE_NUMBER, USER_ROLE, USER_BALANCE) VALUES(?,?,?,?,?,?,?,?)";

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, enryptedPassword);
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
