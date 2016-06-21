package homeworkday2;

/**
 * 
 * @author CUNTAAL
 * @version 1
 */
public class Employee {
	private String first_name;
	private String last_name;
	private String mgrid;
	private String salary;
	private static int i = 0;
	private String Id;

	Employee(String ID, String first_name, String last_name, String mgrid,
			String salary) {
		this.Id = ID; // default
		this.first_name = first_name;
		this.last_name = last_name;
		this.mgrid = mgrid;
		this.salary = salary;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMgrid() {
		return mgrid;
	}

	public void setMgrid(String mgrid) {
		this.mgrid = mgrid;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
