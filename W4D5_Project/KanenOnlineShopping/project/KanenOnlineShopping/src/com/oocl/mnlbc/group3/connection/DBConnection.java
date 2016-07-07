package com.oocl.mnlbc.group3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author FLOREJE JDBC Connection Class
 */
public class DBConnection {

	/**
	 * getting connection give the host, port & SID
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {

		String driver = "oracle.jdbc.driver.OracleDriver";

		// credentials
		String user = "system";
		String password = "redhat";

		// database connection details
		String hostname = "localhost";
		String port = "1521";
		String sid = "xe";

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