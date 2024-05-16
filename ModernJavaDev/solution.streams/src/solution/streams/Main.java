package solution.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.OptionalDouble;
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
		
		displayEmployeeNames();
		
		displayWageBill();

		displaySortedDistinctOffices();
		
		Predicate<Employee> predBerlinOffice = e -> e.getOffice().equals("Berlin");
		Predicate<Employee> predHighlyPaid   = e -> e.getSalary() >= 50000;
		displayFilteredEmployees("Berlin employees", predBerlinOffice);
		displayFilteredEmployees("Highly paid employees", predHighlyPaid);
		displayFilteredEmployees("Highly paid employees in Berlin", predHighlyPaid.and(predBerlinOffice));
		
		displaySalaryStats();
		
		displaySalaryTests("Geneva");
		displaySalaryTests("Lisbon");
	}

	private static void displayEmployeeFullDetails() {
		try (Stream<Employee> stream = emps.stream()) {
			System.out.println("\nFull details of all employees:");
			stream.forEach(Employee::display);
		}				
	}
	
	private static void displayEmployeeNames() {
		try (Stream<Employee> stream = emps.stream()) {
			System.out.println("\nNames of all employees:");
			stream.forEach(e -> System.out.println(e.getName()));
		}				
	}

	private static void displayWageBill() {
		try (Stream<Employee> stream = emps.stream()) {		
			double wageBill = stream.mapToDouble(Employee::getSalary).sum();
			System.out.printf("\nTotal wage bill: £%.2f\n", wageBill);
		}				
	}
	
	private static void displaySortedDistinctOffices() {
		try (Stream<Employee> stream = emps.stream()) {
			System.out.println("\nDistinct offices (alphabetic order):");
			stream.map(Employee::getOffice)
			      .distinct()
			      .sorted()
			      .forEach(o -> System.out.println(o));
		}				
	}
	
	private static void displayFilteredEmployees(String description, Predicate<Employee> predicate) {
		try (Stream<Employee> stream = emps.stream()) {
			System.out.printf("\n%s:\n", description);
			stream.filter(predicate)
			      .forEach(Employee::display);
		}				
	}
	
	private static void displaySalaryStats() {

		try (Stream<Employee> stream = emps.stream()) {
			OptionalDouble min = stream.mapToDouble(Employee::getSalary).min();
			System.out.printf("\nMinimum salary of all employees: %.2f\n", min.orElse(0));
		}				

		try (Stream<Employee> stream = emps.stream()) {
			OptionalDouble max = stream.mapToDouble(Employee::getSalary).max();
			System.out.printf("Maximum salary of all employees: %.2f\n", max.orElse(0));
		}				
		
		try (Stream<Employee> stream = emps.stream()) {
			OptionalDouble average = stream.mapToDouble(Employee::getSalary).average();
			System.out.printf("Average salary of all employees: %.2f\n", average.orElse(0));
		}
		
		try (Stream<Employee> stream = emps.stream()) {
			System.out.println("\nTop 3 employees by salary [descending]:");
			stream.sorted()
			      .limit(3)
			      .forEach(Employee::display);
		}				

		try (Stream<Employee> stream = emps.stream()) {
			System.out.println("\nTop 3 employees by name [ascending]:");
			stream.sorted( (e1,e2) -> e1.getName().compareTo(e2.getName()) )
				  .limit(3)
				  .forEach(Employee::display);
		}				
	}

	private static void displaySalaryTests(String city) {

		try (Stream<Employee> stream = emps.stream()) {
			boolean allEarnEnough = stream.allMatch( e -> e.getSalary() > 7000 );
			System.out.printf("\nAll employees earn at least minimum wage? %s\n", allEarnEnough);
		}				

		try (Stream<Employee> stream = emps.stream()) {
			boolean anyoneEarnTooMuch = stream.anyMatch( e -> e.getSalary() > 1000000 );
			System.out.printf("Any employee earn too much? %s\n", anyoneEarnTooMuch);
		}				

		try (Stream<Employee> stream = emps.stream()) {
			Optional<Employee> firstEmployeeInCity = stream.filter( e -> e.getOffice().equals(city) ).findFirst();
			if (firstEmployeeInCity.isPresent()) {
				System.out.printf("First employee in %s: %s\n", city, firstEmployeeInCity.get());
			}
			else {
				System.out.printf("No employees in %s\n", city);
			}
		}				
	}
}
