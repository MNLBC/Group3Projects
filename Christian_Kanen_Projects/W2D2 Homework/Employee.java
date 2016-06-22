
public class Employee {
	private int id;
	private String first_name;
	private String last_name;
	private String mgrid;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int id, String first_name, String last_name, String mgrid,
			int salary) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mgrid = mgrid;
		this.salary = salary;
	}


}

