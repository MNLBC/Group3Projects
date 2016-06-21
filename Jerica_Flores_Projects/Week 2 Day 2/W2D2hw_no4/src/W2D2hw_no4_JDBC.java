import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class W2D2hw_no4_JDBC {
	public static String driverName = "oracle.jdbc.driver.OracleDriver";
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "system";
		String password = "admin123";
		try {
			Connection conn = DriverManager.getConnection(URL, userName, password);
			Statement sqlStatement = conn.createStatement();
			
			//number 4 - Creating a table Employee
			sqlStatement.executeQuery("CREATE TABLE EMPLOYEE (ID NUMBER PRIMARY KEY, FIRST_NAME VARCHAR (20), LAST_NAME VARCHAR (20), MGRID VARCHAR(20), SALARY NUMBER)");
						
			//number 4 - Inserting records to the table
			sqlStatement.executeUpdate("INSERT INTO EMPLOYEE values(1,'Rose','Tyler',4,1500)");
			sqlStatement.executeUpdate("INSERT INTO EMPLOYEE values(2,'Matha','Jones',4,2200)");
			sqlStatement.executeUpdate("INSERT INTO EMPLOYEE values(3,'Donna','Noble',4,1300)");
			sqlStatement.executeUpdate("INSERT INTO EMPLOYEE values(4,'Doctor','Who','',5500)"); 
			sqlStatement.executeUpdate("INSERT INTO EMPLOYEE values(5,'Jack','Harkness',1,3500)");
			
			ResultSet resultSet = sqlStatement.executeQuery("SELECT * from EMPLOYEE");
			System.out.println("ID\t    FIRST_NAME\t       LAST_NAME\t       MGRID    \tSALARY\t");

			//number 4 - 1 Inserting Alex
			System.out.println("----- After inserting Alex -----");
			sqlStatement.executeUpdate("INSERT INTO EMPLOYEE values(6,'Alex','Lee',1,4500)");	
			resultSet = sqlStatement.executeQuery("SELECT * from EMPLOYEE");
			while (resultSet.next()) {
				System.out.print(resultSet.getString(1) + "\t\t");
				System.out.print(resultSet.getString(2) + "\t\t");
				if (resultSet.getString(3).length() > 5) {
				System.out.print(resultSet.getString(3)+"\t\t");
				}else{
				System.out.print(resultSet.getString(3) + "\t\t\t");
				}
				System.out.print(resultSet.getString(4) + "\t\t");
				System.out.println(resultSet.getString(5));
			}
			
			//number 4 - 2 Updating Jones to Tate
			System.out.println("----- After updating Jones to Tate -----");
			sqlStatement.executeUpdate("UPDATE EMPLOYEE SET LAST_NAME = 'Tate' WHERE LAST_NAME = 'Jones'");
			resultSet = sqlStatement.executeQuery("SELECT * from EMPLOYEE");
			while (resultSet.next()) {
				System.out.print(resultSet.getString(1) + "\t\t");
				System.out.print(resultSet.getString(2) + "\t\t");
				if (resultSet.getString(3).length() > 5) {
				System.out.print(resultSet.getString(3)+"\t\t");
				}else{
				System.out.print(resultSet.getString(3) + "\t\t\t");
				}
				System.out.print(resultSet.getString(4) + "\t\t");
				System.out.println(resultSet.getString(5));
			}
			
			sqlStatement.executeUpdate("DROP TABLE EMPLOYEE");
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}
}
