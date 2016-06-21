package homeworkday2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author CUNTAAL
 * @version 1
 */
public class App {
	public static Connection getConn() {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"system", "admin123");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// Create Table
	public static void create() {
		int i = 0;
		Connection conn = getConn();
		String sql = "CREATE TABLE EMPLOYEE (ID NUMBER (11,0) NOT NULL PRIMARY KEY, FIRST_NAME VARCHAR2(20) NULL,LAST_NAME VARCHAR2(20) NULL, MGRID NUMBER(11,0) NULL, SALARY INTEGER NULL)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Insert Table
	public static int insert(Employee employee) {
		Connection conn = getConn();
		int i = 0;
		String sql = "INSERT INTO EMPLOYEE (Id, first_name,last_name,mgrid,salary) values(?, ?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, employee.getId());
			pstmt.setString(2, employee.getFirst_name());
			pstmt.setString(3, employee.getLast_name());
			pstmt.setString(4, employee.getMgrid());
			pstmt.setString(5, employee.getSalary());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// Update
	public static void update() {
		Connection conn = getConn();
		int i = 0;
		String sql = "update employee set last_name= 'Tate' where LAST_NAME='Jones'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Display All employess
	public static Integer getAll() {
		Connection conn = getConn();
		String sql = "select * from Employee";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("==================Employee==================");
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
					if ((i == 2) && (rs.getString(i).length() < 8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			System.out.println("===========================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
