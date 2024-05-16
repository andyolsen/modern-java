package student.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

	private static Collection<Employee> emps = createEmployees();

	private static Collection<Employee> createEmployees() {
		Collection<Employee> emps = new ArrayList<>();		
		emps.add(new Employee("Peter Smith", "London", 25000));
		emps.add(new Employee("Johan Mitra", "Berlin", 21000));
		emps.add(new Employee("Diane Evans", "London", 32000));
		emps.add(new Employee("Meera Jones", "Geneva", 2500000));
		emps.add(new Employee("Gerry Lomax", "London", 7000));
		emps.add(new Employee("Steff Holby", "Berlin", 55000));
		emps.add(new Employee("Franz Elsom", "Berlin", 75000));
		emps.add(new Employee("Simon Peter", "Geneva", 150000));
		return emps;
	}
	

	public static void main(String... args) {
		
		displayEmployeeFullDetails();
		
		// TODO: Call other functions here...

	}
	
	private static void displayEmployeeFullDetails() {
		try (Stream<Employee> stream = emps.stream()) {
			System.out.println("\nFull details of all employees:");
			stream.forEach(Employee::display);
		}				
	}
	
	private static void displayEmployeeNames() {
		// TODO
	}

	private static void displayWageBill() {
		// TODO
	}
	
	private static void displaySortedDistinctOffices() {
		// TODO
	}
	
	private static void displayFilteredEmployees(String description, Predicate<Employee> predicate) {
		// TODO
	}
	
	private static void displaySalaryStats() {
		// TODO
	}

	private static void displaySalaryTests(String city) { 
		// TODO
	}
}
