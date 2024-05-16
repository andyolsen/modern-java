package demo.streams;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamsDemo {

	public static void main(String... args) {
		
		List<Employee> staff = Employee.generateStaff();
		
		System.out.println("\nUsing mapToDouble() to get a DoubleStream of salaries:");		
		Stream<Employee> empStream = staff.stream();		
		DoubleStream salaryStream = empStream.mapToDouble(Employee::getSalary);
		salaryStream.forEach(s -> System.out.println("  " + s));
		
		System.out.println("\nUsing mapToLong() to get a LongStream of IDs:");		
		empStream = staff.stream();		
		LongStream idStream = empStream.mapToLong(Employee::getId);
		idStream.forEach(id -> System.out.println("  " + id));

		System.out.println("\nUsing mapToInt() to get an IntStream of 'a' position in name:");		
		empStream = staff.stream();		
		IntStream aStream = empStream.mapToInt(emp -> emp.getName().indexOf('a'));
		aStream.forEach(pos -> System.out.println("  " + pos));
	}
}
