import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbTest {
	static PreparedStatement pstmt;
	static Connection con = null;
	static List<Employee> e = new ArrayList<Employee>();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		con = DBConn.getConnection();
		createEmployee();
		insertEmployee();
		displayEmployee();
		updateEmployee();
		System.out.println("Updated Results.....");
		displayEmployee();
		con.close();
	}

	public static void createEmployee() throws SQLException {
		int i = 0;
		String sql = "CREATE TABLE EMPLOYEE (Id NUMBER(11) NOT NULL PRIMARY KEY, "
				+ "	FIRST_NAME VARCHAR(30), LAST_NAME VARCHAR(20), MGRID VARCHAR(2), SALARY INTEGER)";

		pstmt = (PreparedStatement) con.prepareStatement(sql);
		i = pstmt.executeUpdate();
	}

	public static void addEmployee() {
		e.add(new Employee(1, "Rose", "Tyler", "4", 1500));
		e.add(new Employee(2, "Matha", "Jones", "4", 2200));
		e.add(new Employee(3, "Donna", "Noble", "4", 1300));
		e.add(new Employee(4, "Doctor", "Who", " ", 5500));
		e.add(new Employee(5, "Jack", "Harkness", "1", 3500));
		e.add(new Employee(6, "Alex", "Lee", "1", 4500));
	}

	public static void insertEmployee() {
		addEmployee();

		int i = 0;
		String sql = "insert into Employee values(?,?,?,?,?)";
		PreparedStatement pstmt;
		for (Employee list : e) {
			try {
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, Integer.toString(list.getId()));
				pstmt.setString(2, list.getFirst_name());
				pstmt.setString(3, list.getLast_name());
				pstmt.setString(4, list.getMgrid());
				pstmt.setString(5, Integer.toString(list.getSalary()));
				i += pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public static void displayEmployee() {

		String sql = "select * from Employee";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print("\t" + rs.getString(i) + "\t");
					if ((i == 2) && (rs.getString(i).length() < 8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static void updateEmployee() {

		int i = 0;
		String sql = "update Employee set LAST_NAME='Tate' where LAST_NAME='Jones'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			i = pstmt.executeUpdate();
			System.out.println("resutl: " + i);
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println("Update Completed!!!");
	}

}