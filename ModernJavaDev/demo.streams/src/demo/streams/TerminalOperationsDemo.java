package demo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsDemo {

	public static void main(String... args) {
		
		List<Integer> lotto = generateRandomNumbers();

		demo1(lotto);
		demo2(lotto);
	}

	private static void demo1(List<Integer> lotto) {
		
		System.out.println("\nUsing forEach() to print all elements:");
		Stream<Integer> stream = lotto.stream();		
		stream.forEach(n -> System.out.print("  " + n));

		System.out.println("\n\nUsing count() to count the elements:");
		stream = lotto.stream();		
		long count = stream.count();
		System.out.println("  Count: " + count);

		System.out.println("\nUsing min() to find minimum element:");
		stream = lotto.stream();		
		// Optional<T> is a new class in java.util package, represents a nullable type (like in C#!).
		Optional<Integer> min = stream.min(Integer::compareTo);
		System.out.println("  Minimum value: " + min.orElse(-1));

		System.out.println("\nUsing max() to find maximum element:");
		stream = lotto.stream();		
		// For variety, we've passed in an explicit implementation for the Comparator<T> here.
		Optional<Integer> max = stream.max((n1, n2) -> n1 - n2);
		System.out.println("  Maximum value: " + max.orElse(-1));

		System.out.println("\nUsing toArray() to copy elements into an array:");
		stream = lotto.stream();		
		Object[] array = stream.toArray();
		System.out.println("  Element [3] is " + array[3]);

		System.out.println("\nUsing collect() to copy elements into a list:");
		stream = lotto.stream();		
		// The collect() method takes a Collector object, to specify the type of collection.
		// The easiest way to create a Collector is via the Collectors utility class.
		// In this example, we use Collectors.toList() to get back a list.
		List<Object> list = stream.collect(Collectors.toList());
		list.add(49);
		System.out.println("  Count of elements is " + list.size());

		System.out.println("\nUsing collect() to copy elements into a map:");
		List<Employee> staff = Employee.generateStaff();
		Stream<Employee> empStream = staff.stream();		
		// In this example, we use Collectors.groupingBy() to get back a map grouped by employee's office.
		Map<String, List<Employee>> groupedStaff = empStream.collect(Collectors.groupingBy(Employee::getOffice));
		System.out.println("  Number of employees in London is " + groupedStaff.get("London").size());

		System.out.println("\nUsing reduce() to reduce elements:");
		stream = lotto.stream();		
		Optional<Integer> result = stream.reduce((n1, n2) -> n1 + n2);
		System.out.println("  Reduced value: " + result.orElse(-1));
	}
	
	private static void demo2(List<Integer> lotto) {
		
		System.out.println("\nUsing anyMatch() to determine if any element matches a Predicate:");
		Stream<Integer> stream = lotto.stream();		
		boolean result = stream.anyMatch(n -> n >= 10);
		System.out.println("  Any element >= 10? " + result);
		
		System.out.println("\nUsing allMatch() to determine if all elements match a Predicate:");
		stream = lotto.stream();		
		result = stream.allMatch(n -> n >= 10);
		System.out.println("  All elements >= 10? " + result);

		System.out.println("\nUsing noneMatch() to determine if no elements match a Predicate:");
		stream = lotto.stream();		
		result = stream.noneMatch(n -> n >= 10);
		System.out.println("  No element >= 10? " + result);

		System.out.println("\nUsing findFirst() to find first element in stream:");
		stream = lotto.stream();		
		Optional<Integer> first = stream.findFirst();
		System.out.println("  First element: " + first.orElse(-1));

		System.out.println("\nUsing findAny() to find any element in stream:");
		stream = lotto.stream();		
		Optional<Integer> any = stream.findAny();
		System.out.println("  Any element: " + any.orElse(-1));
	}

	private static List<Integer> generateRandomNumbers() {
		Random r = new Random();
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			numbers.add(1 + r.nextInt(49));
		}
		return numbers;
	}
}
