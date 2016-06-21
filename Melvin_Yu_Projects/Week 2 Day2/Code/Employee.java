
public class Employee {
	
	
	private int id;
	private String fname;
	private String lname;
	private String mgrid;
	private float salary;

	/**
	 * @param id
	 * @param fname
	 * @param lname
	 * @param mgrid
	 * @param salary
	 */
	public Employee(int id, String fname, String lname, String mgrid, float salary) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.mgrid = mgrid;
		this.salary = salary;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the mgrid
	 */
	public String getMgrid() {
		return mgrid;
	}
	/**
	 * @param mgrid the mgrid to set
	 */
	public void setMgrid(String mgrid) {
		this.mgrid = mgrid;
	}
	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	

}
