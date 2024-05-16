package student.streams;

public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private String office;
	private double salary;

	private static int nextId = 1;

	public Employee(String name, String office, double salary) {
		this.id = nextId++;
		this.name = name;
		this.office = office;
		this.salary = salary;
	}
		
	public void display() {
		System.out.printf("%s\n", this);
	}
	
	@Override
	public String toString() {
		return String.format("[%d] %s, %s, £%.2f", id, name, office, salary);
	}
		
	// Allow Employees to be sorted by salary, in descending order (i.e. highest salary first)
	@Override
	public int compareTo(Employee other) {
		if (this.salary < other.salary)
			return 1;
		else if (this.salary > other.salary)
			return -1;
		else 
			return 0;
	}

	public String getName() {
		return name;
	}

	public String getOffice() {
		return office;
	}

	public double getSalary() {
		return salary;
	}
}
