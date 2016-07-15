package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.group3.connection.DBConnection;
import com.oocl.mnlbc.group3.model.UserBean;
import com.oocl.mnlbc.group3.security.PasswordEncrypter;
import com.oocl.mnlbc.group3.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.group3.security.PasswordEncrypter.InvalidHashException;

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
		String sql = "SELECT 1 FROM USERS WHERE " + "USERNAME ='" + username + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLSyntaxErrorException se) {
			System.out.println("Error in checking if user exists.");
			se.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean emailExists(String email) {
		String sql = "SELECT 1 FROM USERS WHERE " + "EMAIL ='" + email + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLSyntaxErrorException se) {
			System.out.println("Error in checking if email exists.");
			se.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public UserBean validateAccount(String username, String password) {
		UserBean user = null;
		String sql = "SELECT * FROM USERS WHERE " + "USERNAME ='" + username + "'" ;
		//+ "AND USER_PASSWORD ='" + password + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String passwordHash = rs.getString("USER_PASSWORD");
				try {
					if (PasswordEncrypter.verifyPassword(password, passwordHash)) {
						System.out.println("fasdfasfas");
						int id =Integer.parseInt(rs.getString("USER_ID"));
						username =rs.getString("USERNAME");
						String fullName = rs.getString("FULL_NAME");
						String email =rs.getString("EMAIL");
						String deliveryAddress = rs.getString("ADDRESS");
						String mobileNumber = rs.getString("MOBILE_NUMBER");
						String userRole = rs.getString("USER_ROLE");
						
						user = new UserBean(id,username,passwordHash,fullName,email,deliveryAddress,mobileNumber,userRole);
						return user;
					}
				} catch (CannotPerformOperationException e) {
					e.printStackTrace();
				} catch (InvalidHashException e) {
					e.printStackTrace();
				}
				return null;

			}
		} catch (SQLSyntaxErrorException se) {
			se.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean registerUser(UserBean user) {

		String username = user.getUserName();
		String userPassword = user.getUserPassword();
		String fullName = user.getFullName();
		String email = user.getEmail();
		String deliveryAddress = user.getAddress();
		String mobileNumber = user.getMobileNumber();
		String userRole = user.getUserRole();

		int i = 0;

		String sql = "INSERT INTO USERS" + "(USERNAME," + "USER_PASSWORD," + "FULL_NAME," + "EMAIL," + "ADDRESS,"
				+ "MOBILE_NUMBER," + "USER_ROLE)" + "VALUES(?,?,?,?,?,?,?)";

		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(userPassword);
		} catch (CannotPerformOperationException e1) {
			e1.printStackTrace();
		}

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, enryptedPassword);
			pstmt.setString(3, fullName);
			pstmt.setString(4, email);
			pstmt.setString(5, deliveryAddress);
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

	@Override
	public List<UserBean> getBannedUsers() {
		List<UserBean> bannedUsers = new ArrayList<UserBean>();
		//String sql = "SELECT USER_ID, USERNAME, USER_PASSWORD, FULL_NAME, EMAIL,ADDRESS, MOBILE_NUMBER, USER_ROLE FROM USERS WHERE IS_BLACKLISTED=? ";
		String sql = "SELECT USER_ID, USERNAME, USER_PASSWORD, FULL_NAME, EMAIL,ADDRESS, MOBILE_NUMBER, USER_ROLE FROM USERS WHERE IS_BLACKLISTED=? ";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, "YES");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bannedUsers.add(new UserBean(Integer.parseInt(rs.getString("USER_ID")), rs.getString("USERNAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bannedUsers;
	}
}
