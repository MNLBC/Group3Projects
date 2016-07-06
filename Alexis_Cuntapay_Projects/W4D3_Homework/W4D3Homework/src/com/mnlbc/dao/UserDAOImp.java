/**
 * 
 */
package com.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import com.mnlbc.model.User;
import com.mnllbc.database.DBConn;

/**
 * @author FLOREJE Implementation of DB transactions.
 */
public class UserDAOImp implements UserDAO {

	private final static UserDAOImp userDAO = new UserDAOImp();
	Connection conn;
	PreparedStatement pstmt;

	/**
	 * private because no need to new the Class everytime. only need one
	 * instance
	 */
	private UserDAOImp() {
		conn = DBConn.getConnection();
	}

	/**
	 * returns the Instance of the class.
	 * 
	 * @return AccountDAOImpl
	 */
	public static UserDAOImp getInstance() {
		return userDAO;
	}

	@Override
	/**
	 * 
	 * @return boolean
	 */
	
	public boolean registerAccount(User user) {
		String email = "";
		String username = "";
		String fname="";
		String lname = "";
		String password="";
	    email = user.getEmail();
		username = user.getUsername();
		fname = user.getFname();
		lname = user.getLname();
		password = user.getPassword();
		

		int i = 0;

		String sql = "INSERT INTO USERS (email,username,fname, lname, password) VALUES(?, ?, ?, ?, ?)";

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, username);
			pstmt.setString(3, fname);
			pstmt.setString(4, lname);
			pstmt.setString(5, password);

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
	public boolean checkIfUserExist(String username) {

		String sql = "SELECT * FROM USERS WHERE username ='" + username + "'";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLSyntaxErrorException se) {
			System.out.println("User does not exist.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}

