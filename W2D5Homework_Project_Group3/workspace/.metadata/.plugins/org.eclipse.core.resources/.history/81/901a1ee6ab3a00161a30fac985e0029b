/**
 * 
 */
package com.oocl.mnlbc.group3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import com.oocl.mnlbc.group3.connection.DBConn;
import com.oocl.mnlbc.group3.model.Account;

/**
 * @author FLOREJE
 * Account
 * User_Chat_Assn
 * Chat_History
 */
public class AccountDAOImpl implements AccountDAO {
	
	private final static AccountDAOImpl accountDAO = new AccountDAOImpl();
	Connection conn;
	PreparedStatement pstmt;
	
	private AccountDAOImpl() {
		conn = DBConn.getConnection();
	}
	
	public static AccountDAOImpl getInstance(){
		return accountDAO;
	}
	
	@Override
	public boolean checkIfUserExist(String username) {
     
  
		String sql = "SELECT * FROM ACCOUNT WHERE username ='" + username+"'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return true;			
			}
		
		}catch (SQLSyntaxErrorException se) {
			System.out.println("User does not exist.");
		} catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registerAccount(Account account) {
		String fullname="";
		String username="";
		String password="";
		fullname=account.getFullname();
		username = account.getUsername();
		password = account.getPassword();
	
		
		int i=0;
	
		String sql = "INSERT INTO ACCOUNT (fullname,username, password) VALUES(?, ?, ?)";
	    
	    try {
	    	
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, fullname);
	        pstmt.setString(2, username);
	        pstmt.setString(3, password);
	        
	        i = pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    if(!(i==0)){
	    	return true;
	    }
		return false;
	}

	@Override
	public boolean validateAccount(String username, String password) {
		
		String sql = "SELECT * FROM ACCOUNT WHERE username ='" + username +"' and password ='" + password +"'";

		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		
		}catch (SQLSyntaxErrorException se) {
			//System.out.println("Wrong username or password.");
		} catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveChatHistory() {
		String chat_history="";
		String chat_date="";
		String sql = "INSERT INTO CHAT_HISTORY (chat_history, chat_date) VALUES(?, ?)";
		int i=0;
	    
	    try {	
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, chat_history);
	        pstmt.setString(2, chat_date);
	        
	        i = pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    if(!(i==0)){
	    	return true;
	    }
	    return false;
	}

	@Override
	public boolean addUserChatAssn() {
		int chat_id=0;
		int account_id=0;
		int i = 0;
		
		String sql = "INSERT INTO USER_CHAT_ASSN (chat_id, account_id) VALUES(?, ?)";
	    
	    try {
	    	
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setInt(1, chat_id);
	        pstmt.setInt(2, account_id);
	        
	        i = pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	    if(!(i==0)){
	    	return true;
	    }
		return false;
	}

}
