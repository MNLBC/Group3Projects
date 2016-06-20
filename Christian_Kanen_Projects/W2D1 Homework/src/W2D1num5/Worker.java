package W2D1num5;

public class Worker implements Comparable{
	private int age;
	private String name;
	private double salary;
	public Worker() { 
	}
	public Worker (String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
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
		System.out.println(name + " is working");
	}
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
	
	/*Over write the equals method for the class Worker. 
	  New equals method return true only if the workers�� name, age and salary are the same at the same time.*/
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
		if (Double.doubleToLongBits(salary) != Double
				.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Worker otherworker = (Worker) o;
		double salary = otherworker.getSalary();
		
		if (this.salary > salary){
			return 1;
		}else if (this.salary < salary){
			return -1;
		}else {
			return 0;
		}
	}
	
}
