package demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleStreamDemo {

	public static void main(String... args) {
		
		// Collection of hours worked each day this week.
		List<Double> hoursWorked = Arrays.asList(7.5, 8.25, 9.0, 7.0, 6.5);
		
		// Get a sequential stream on the collection.
		Stream<Double> stream = hoursWorked.stream();
		
		// Perform some operations on the collection elements.
		double sumExtraHours = stream.filter(h -> h > 7.5)           // Intermediate operation.
		                             .mapToDouble(h -> h - 7.5)      // Intermediate operation.
		                             .sum();                         // Terminal operation.
		
		System.out.println("Sum of extra hours worked this week: " + sumExtraHours);
	}
}
