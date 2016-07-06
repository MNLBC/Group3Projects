/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.db.DBConn;

/**
 * @author kanench
 *
 */
public class AccountDaoImpl implements AccountDao {

	private final static AccountDaoImpl accDao = new AccountDaoImpl();
	Connection conn;
	PreparedStatement pstmt;

	private AccountDaoImpl() {
		// TODO Auto-generated constructor stub
		conn = DBConn.getConnection();
	}
	
	public static AccountDaoImpl getInstance(){
		return accDao;
	}

	@Override
	public boolean userExists(String uname) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USERS WHERE USERNAME = '" + uname + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("USER DOES NOT EXISTS!");
		}

		return true;
	}

	@Override
	public boolean userRegister(String uname, String pword, String fname,
			String add, String cnt, String email) {
		// TODO Auto-generated method stub
		int i = 0;

		String sql = "INSERT INTO USERS VALUES (?,?,?,?,?,?)";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);
			pstmt.setString(3, fname);
			pstmt.setString(4, add);
			pstmt.setString(5, cnt);
			pstmt.setString(6, email);

			i = pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!(i == 0)) {
			return true;
		}
		return false;
	}

}
