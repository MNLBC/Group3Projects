package com.oocl.mnlbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kanench
 */
public class DBConn {

	/**
	 * getting connection give the host, port & sid
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {

		//String driver = "oracle.jdbc.driver.OracleDriver";
		String driver = "oracle.jdbc.driver.OracleDriver";

		// credentials
		String user = "tutor";
		String password = "oracle";

		// database connection details
		//String hostname = "zha-ita122-w7";
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
