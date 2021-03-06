/**
 * 
 */
package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.group3.connection.DBConn;
import com.oocl.mnlbc.group3.model.Account;
import com.oocl.mnlbc.group3.model.Chat;

/**
 * @author FLOREJE Implementation of DB transactions.
 */
public class AccountDAOImpl implements AccountDAO {

	private final static AccountDAOImpl accountDAO = new AccountDAOImpl();
	Connection conn;
	PreparedStatement pstmt;

	/**
	 * private because no need to new the Class everytime. only need one
	 * instance
	 */
	private AccountDAOImpl() {
		conn = DBConn.getConnection();
	}

	/**
	 * returns the Instance of the class.
	 * 
	 * @return AccountDAOImpl
	 */
	public static AccountDAOImpl getInstance() {
		return accountDAO;
	}

	@Override
	/**
	 * 
	 * @return boolean
	 */
	public boolean checkIfUserExist(String username) {

		String sql = "SELECT * FROM ACCOUNT WHERE username ='" + username + "'";

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
	/**
	 * @return boolean
	 */
	public boolean registerAccount(Account account) {
		String fullname = "";
		String username = "";
		String password = "";
		fullname = account.getFullname();
		username = account.getUsername();
		password = account.getPassword();

		int i = 0;

		String sql = "INSERT INTO ACCOUNT (fullname,username, password) VALUES(?, ?, ?)";

		try {

			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, fullname);
			pstmt.setString(2, username);
			pstmt.setString(3, password);

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
	/**
	 * @return boolean
	 */
	public boolean validateAccount(String username, String password) {

		String sql = "SELECT * FROM ACCOUNT WHERE username ='" + username + "' and password ='" + password + "'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLSyntaxErrorException se) {
			// System.out.println("Wrong username or password.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	/**
	 * @return boolean
	 */
	public boolean saveChatHistory(Chat chat) {
		String username = "";
		String chat_history = "";
		String chat_date = "";
		chat_history = chat.getChat();
		chat_date = chat.getDate();
		username = chat.getUsername();
		String sql = "INSERT INTO CHAT_HISTORY (username,chat_message, chat_date) VALUES(?,?, ?)";
		int i = 0;

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, chat_history);
			pstmt.setString(3, chat_date);
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
	/**
	 * @return List<Chat>
	 */
	public List<Chat> getPreviousChat() {
		// TODO Auto-generated method stub
		List<Chat> history = new ArrayList<Chat>();
		String sql = "SELECT * FROM chat_history order by chat_date desc";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				history.add(
						new Chat(rs.getString("username"), rs.getString("chat_message"), rs.getString("chat_date")));
			}
		} catch (SQLSyntaxErrorException se) {
			// System.out.println("Wrong username or password.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return history;
	}

}
