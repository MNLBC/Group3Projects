package com.oocl.mnlbc.group3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.oocl.mnlbc.group3.util.GetDBConfigUtil;

/**
 * @author FLOREJE Database Connection Class
 */
public class DBConnection {

	/**
	 * 
	 * Establishes the database connection
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {

		GetDBConfigUtil dbUtil = new GetDBConfigUtil();

		String driver = dbUtil.getDriver();
		String hostname = dbUtil.getHostname();
		String port = dbUtil.getPort();
		String sid = dbUtil.getSid();

		String user = dbUtil.getUser();
		String password = dbUtil.getPassword();

		String URL = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + sid;

		Connection conn = null;

		try {

			Class.forName(driver);
			conn = DriverManager.getConnection(URL, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load oracle driver");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Unable to establish a connection.");
			e.printStackTrace();
		}

		return conn;

	}
}