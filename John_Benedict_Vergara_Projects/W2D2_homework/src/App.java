import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author vergajo
 *
 */
public class App {

	/**
	 * @param args
	 */

	static String driverName = "oracle.jdbc.driver.OracleDriver";
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "admin123";

		try {
			Connection conn = DriverManager.getConnection(URL, username, password);

			// create a statement before doing SQL query
			Statement sqlStatement = conn.createStatement();

			// Create Employee Table.
			ResultSet resultSet = sqlStatement.executeQuery(
					"CREATE TABLE Employee(id number(11,0) Primary key NOT NULL, first_name varchar(50), last_name varchar(50), mgrid number, salary NUMBER)");

			// Insert Values into Employee Table.
			sqlStatement.executeUpdate("INSERT INTO Employee values(1,'rose', 'Tyle', 4, 1500)");
			sqlStatement.executeUpdate("INSERT INTO Employee values(2,'Martha', 'Jones', 4, 2200)");
			sqlStatement.executeUpdate("INSERT INTO Employee values(3,'Donna', 'Noble', 4, 1300)");
			sqlStatement.executeUpdate("INSERT INTO Employee values(4,'Doctor', 'Who', '', 5500)");
			sqlStatement.executeUpdate("INSERT INTO Employee values(5,'Jack', 'Harknes', 1, 3500)");

			resultSet = sqlStatement.executeQuery("SELECT * FROM Employee");
			
			System.out.println("*********************************************************");
			System.out.println("ID\tFirst Name\tLastName\tMGRID\tSalary\t*");

			// Insert Alex into Employee Table
			sqlStatement.executeUpdate("INSERT INTO Employee values(6,'Alex','Lee', 1, 4500)");

			resultSet = sqlStatement.executeQuery("SELECT * FROM Employee");
			// Display the Employee Table
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t" + resultSet.getString(5) + "\t*");
			}

			// Updated Jones into Tate
			sqlStatement.executeUpdate("update Employee set last_name = 'Tate' where last_name = 'Jones'");

			System.out.println("*********************************************************");
			System.out.println("ID\tFirst Name\tLastName\tMGRID\tSalary\t*");
			resultSet = sqlStatement.executeQuery("SELECT * FROM Employee");

			// Display the Employee Table
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t" + resultSet.getString(5) + "\t*");
			}
			System.out.println("*********************************************************");
			
			// Drop the employee table
			sqlStatement.executeQuery("DROP TABLE Employee");
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
