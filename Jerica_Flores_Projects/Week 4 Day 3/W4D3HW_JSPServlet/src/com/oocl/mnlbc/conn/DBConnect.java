package com.oocl.mnlbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public Connection getConn() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "admin123";
		Connection conn = null;
		try {
			Class.forName(driver);
			if (tryConnect(username, password)) {
				conn = (Connection) DriverManager.getConnection(url, username, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public boolean tryConnect(String username, String password) {
		if (username == "system" && password == "admin123") {
			return true;
		} else {
			return false;
		}
	}

}