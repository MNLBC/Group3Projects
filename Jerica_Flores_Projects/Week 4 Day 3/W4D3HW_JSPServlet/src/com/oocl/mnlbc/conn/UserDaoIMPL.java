package com.oocl.mnlbc.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oocl.mnlbc.user.User;

public class UserDaoIMPL implements UserDaoInterface {
	static DBConnect db = new DBConnect();

	public boolean addUser(User user) {
		Connection conn = db.getConn();
		String sql = "insert into USERS (fullname,username,password,email) values(?,?,?,?)";
		PreparedStatement pstmt;
		int success = 0;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getFullname());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());

			success = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (success > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isUserExisting(User users) {
		Connection conn = db.getConn();
		String sql = "SELECT * from USERS where username = '" + users.getUsername() + "'";

		PreparedStatement pstmt;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
