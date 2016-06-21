import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConn {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load oracle driver");

			e.printStackTrace();

		}
		String user = "system";
		String pass = "admin1234";
		String host = "localhost";
		String port = "1521";
		String service = "xe";

		String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + service;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

}