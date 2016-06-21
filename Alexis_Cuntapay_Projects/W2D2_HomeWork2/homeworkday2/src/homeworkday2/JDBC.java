package homeworkday2;

import java.sql.SQLException;

public class JDBC {

	public static void main(String args[]) {
		// App.create();
		// Insert Information of employees
		App.insert(new Employee("", "rose", "Tyler", "4", "1500"));
		App.insert(new Employee("", "Matha", "Jones", "4", "2200"));
		App.insert(new Employee("", "Donna", "Noble", "4", "1300"));
		App.insert(new Employee("", "Doctor", "Who", "", "5500"));
		App.insert(new Employee("", "Jack", "Harness", "1", "3500"));
		App.insert(new Employee("", "Alex", "Lee", "1", "4500"));
		// Modify Employee
		App.update();
		// Display All Employees
		App.getAll();

	}

}
