package w2d2.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

/**
 * 
 * Class to create a connection and do the basic database CRUD operations
 * 
 * @author BRIONSE
 * @version 1.0
 * 
 */
public class JDBCOperation {

	/**
	 * Creates a Connection object
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
	
	/**
	 * Creates the Employee Table using a 
	 * PreparedStatement
	 * @return int
	 * @throws SQLSyntaxErrorException if the table already exists.
	 * @throws SQLException for other database access errors.
	 */
	public static int createTableEmployee(){
		Connection conn = getConnection();
		int i = 0;
		
		String createEmployeeSql = "CREATE TABLE EMPLOYEE("
				                     + "  ID         NUMBER"
				                     + " ,FIRST_NAME VARCHAR(45)"
				                     + " ,LAST_NAME  VARCHAR(45)"
				                     + " ,MGRID      NUMBER"
				                     + " ,SALARY     NUMBER(12,2)"
				                     + " ,CONSTRAINT pk_id PRIMARY KEY (ID)"
				                     + " )";
		try {
			Statement createEmpStmt = conn.createStatement();
			i = createEmpStmt.executeUpdate(createEmployeeSql);
			
			createEmpStmt.close();
			conn.close();
		}catch (SQLSyntaxErrorException se) {
			
			System.out.println("EMPLOYEE Table already exists.");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * Inserts a new Employee to the EMPLOYEE table
	 * @param int id
	 * @param String firstName
	 * @param String lastname
	 * @param int mgrid
	 * @param int salary
	 * 
	 * @throws SQLIntegrityConstraintViolationException when the primary key is already used.
	 * @throws SQLException for other database access errors.
	 */
	public static int insertEmployee(int id, String firstName, String lastname, int mgrid, int salary){
		int i = 0;
		
		Connection conn = getConnection();
		String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?)";
	    PreparedStatement pstmt;
	    
	    try {
	    	
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, firstName);
	        pstmt.setString(3, lastname);
	        pstmt.setInt(4, mgrid);
	        pstmt.setInt(5, salary);
	        
	        i = pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    } catch(SQLIntegrityConstraintViolationException ce){
	    	
	    	System.out.println("Employee ID is already used.");
	    	
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
		return i;
	}
	
	/**
	 * Updates the lastName of the employee with the given value
	 * 
	 * @param String - newValue
	 * @param String - originalLastName used for the where clause
	 * @return int - 0 if no record is updated.
	 * @throws SQLException for other database access errors.
	 */
	public static int updateEmployeeByLastName(String newValue, String originalLastname){
		
		Connection conn = getConnection();
	    int i = 0;
	    String sql = "UPDATE EMPLOYEE SET LAST_NAME='" + newValue +"' WHERE LAST_NAME='" + originalLastname + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	/**
	 * 
	 * Selects all employees from the EMPLOYEE table
	 *  ordered by their last name.
	 * 
	 * @throws SQLSyntaxException if the EMPLOYEE table is not found
	 * @throws SQLException for other database access errors.
	 */
	public static void viewEmployees(){
		
		Connection conn = getConnection();
		String sql = "SELECT * FROM EMPLOYEE ORDER BY LAST_NAME";

		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet empRs = pstmt.executeQuery();
			
			int columnCount = empRs.getMetaData().getColumnCount();
			
			System.out.println("============================================");
			while(empRs.next()){
				
				for(int i=1; i<= columnCount; i++){
					System.out.print(empRs.getString(i) + "\t");
					if ((i == 2) && (empRs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
				}
				System.out.println("\n");
			}
			
			System.out.println("============================================");
			
		}catch (SQLSyntaxErrorException se) {
			System.out.println("EMPLOYEE Table not found.");
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
}
