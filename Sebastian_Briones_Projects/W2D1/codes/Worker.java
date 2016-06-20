package w2d1.homework;

/**
 * 
 * Worker class Used in demonstrating the ArrayList and  HashMap
 * Implements Comparable
 * @author BRIONSE
 * @version 1.0
 * 
 */
public class Worker implements Comparable {

	private String id;

	private int age;
	private String name;
	private double salary;

	public Worker() {

	}

	/**
	 * Constructor
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Worker(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * Getters and setters
	 * 
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void work() {
		System.out.println(name + "is working");
	}

	/**
	 * 
	 * Needed to be overridden when overriding equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * 
	 *  Returns true if and only if the worker's name, age and
	 *  salary are the same.
	 *  @param Object obj
	 *  @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	/**
	 * 
	 * Compares the salary of two workers
	 * @param Object 
	 * @return int
	 */
	@Override
	public int compareTo(Object other) {
		Worker otherWorker = (Worker) other;

		if (this.getSalary() > otherWorker.getSalary()) {
			return -1;
		} else if (this.getSalary() < otherWorker.getSalary()) {
			return 1;
		} else {
			return 0;
		}

	}

}
