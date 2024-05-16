package demo.streams;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private long id;
	private String name;
	private String office;
	private double salary;
	
	public Employee(long id, String name, String office, double salary) {
		this.id = id;
		this.name = name;
		this.office = office;
		this.salary = salary;
	}
	
	public static List<Employee> generateStaff() {
		List<Employee> staff = new ArrayList<Employee>();

		staff.add(new Employee(10001000, "John Smith", "London", 25000));
		staff.add(new Employee(20002000, "Bill Evans", "Manchester", 35000));
		staff.add(new Employee(30003000, "Mary Jones", "London", 45000));
		staff.add(new Employee(40004000, "Sara Dawes", "Manchester", 55000));
		staff.add(new Employee(50005000, "Rich Elsom", "London", 65000));
		
		return staff;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", office=" + office + ", salary=" + salary + "]";
	}
}