package w2d2.homework;

/**
 * 
 * Class for testing JDBC Operations
 * 
 * @author BRIONSE
 * @version 1.0
 * 
 */
public class TestJDBC {

	/**
	 * Main method for demonstrating JDBC Crud operations
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Create EMPLOYEE Table
		JDBCOperation.createTableEmployee();
		System.out.println();

		// Populate the Employee table
		JDBCOperation.insertEmployee(1, "Rose", "Tyler", 4, 1500);
		JDBCOperation.insertEmployee(2, "Martha", "Jones", 4, 2200);
		JDBCOperation.insertEmployee(3, "Donna", "Noble", 4, 1300);
		JDBCOperation.insertEmployee(4, "Doctor", "Who", 1, 5500);
		JDBCOperation.insertEmployee(6, "Alex", "Lee", 1, 4500);

		System.out.println();

		// Update the employee's last_name to Tate whose last_name='Jones'

		int rowsUpdated = 0;
		rowsUpdated = JDBCOperation.updateEmployeeByLastName("Tate", "Jones");
		if (rowsUpdated == 0) {
			System.out.println("No records have been updated.");
		} else {
			System.out.println(rowsUpdated + "record(s) updated");
		}

		System.out.println();

		// View all employees
		JDBCOperation.viewEmployees();

	}

}
