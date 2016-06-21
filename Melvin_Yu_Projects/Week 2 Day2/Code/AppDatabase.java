import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppDatabase {
	/**
	 * Connection
	 * ResultSet
	 * Statement
	 * PreparedStatement
	 * List
	 */
	static Connection con;
	static Statement statement;
	static ResultSet resultSet;
	static PreparedStatement pstmt;
	static List<Employee> emp;

	/**
	 * Constructor.
	 */
	public AppDatabase() {
		// TODO Auto-generated constructor stub
		con = JDBCConn.getConnection();
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		AppDatabase app = new AppDatabase();
		/**
		 * 		At first in database, create a table Employee, id is primary key. 
		 * 		1)	Create a table, and insert a record to the table, and print out all the data in the table
		 * 		(6, Alex, Lee, 1, 4500)
		 */
		/**
		 * Start of #1
		 */
		createEmployeeTable();// create employee table
		insertAllEmployee();// adding all the employees given including "Alex Lee"
		/**
		 * End of #1
		 */
		displayAll();// displaying all the values in the table
		
		/**
		 * 		2) Modify the last_name to “Tate” whose last_name is “Jones” , and save it to database.
		 *  	And print out all the data in the table.
		 */
		/**
		 * Start of #1
		 */
		updateLastName();//updating Last_Name to "Tate" where Last_Name is "Jones"
		displayAll();
		/**
		 * End of #2
		 */

		con.close();

	}
	
	/**
	 * Creating Employee Table
	 * @throws SQLException
	 */
	public static void createEmployeeTable() throws SQLException {
		String sql;
		sql = "create table Employee(id Number(11,0) Primary Key NOT NULL, first_name varchar(20), last_name varchar(20), mgrid number(11,0), salary float)";
		int i = 0;

		pstmt = (PreparedStatement) con.prepareStatement(sql);
		i = pstmt.executeUpdate();
		System.out.println("Result: " + i);

	}
	
	/**
	 * adding employee to EmployeeList to be inserted to the employee table
	 */
	public static void addEmpToList() {
		emp = new ArrayList<Employee>();
		emp.add(new Employee(1, "rose", "Tyler", "4", 1500));
		emp.add(new Employee(2, "Matha", "Jones", "4", 2200));
		emp.add(new Employee(3, "Donna", "Noble", "4", 1300));
		emp.add(new Employee(4, "Doctor", "Who", "", 5500));
		emp.add(new Employee(5, "Jack", "Harkness", "1", 3500));
		emp.add(new Employee(6, "Alex", "Lee", "1", 4500));
	}
	
	/**
	 * Inserting All Employees By using prepared statement. getting the values from the emp List
	 * @throws SQLException
	 */
	public static void insertAllEmployee() throws SQLException {

		addEmpToList();
		String sql;
		sql = "insert into employee values(?,?,?,?,?)";
		int res = 0;

		for (Employee worker : emp) {
			try {
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, "" + worker.getId());
				pstmt.setString(2, worker.getFname());
				pstmt.setString(3, worker.getLname());
				pstmt.setString(4, worker.getMgrid());
				pstmt.setString(5, "" + worker.getSalary());
				res += pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Employee Table has been Created!");
	}
	
	
	/**
	 * Displaying All Values of the Employee Table
	 */
	public static void displayAll() {

		String sql = "select * from employee";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("=============Employees==============");

			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					if ((i == 3) && (rs.getString(i).length() > 7)) {
						System.out.print(rs.getString(i) + "\t");
					} else {
						System.out.print(rs.getString(i) + "\t\t");
					}

				}
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Updating Last_Name Column in Employee Table
	 */
	public static void updateLastName() {
		Employee employee = null;
		int res = 0;
		String sql = "select * from employee where last_name='Jones'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// if value can be found 
				employee = new Employee(Integer.parseInt(rs.getString("id")), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("mgrid"), Integer.parseInt(rs.getString("salary")));
				

				sql = "update employee set last_name='Tate' where last_name='" + employee.getLname() + "'";

				try {
					PreparedStatement pstmt1 = (PreparedStatement) con.prepareStatement(sql);
					res = pstmt1.executeUpdate();
					System.out.println("resutl: " + res);
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Updated Completed! Result: " + res);
	}
}
