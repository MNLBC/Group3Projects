import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load oracle driver");

			e.printStackTrace();

		}

		String user = "system";
		String password = "admin123";

		String hostname = "localhost";
		String port = "1521";
		String sid = "xe";

		String URL = "jdbc:oracle:thin:@" + hostname + ":" + "1521" + ":" + "xe";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

}