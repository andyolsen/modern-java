package demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class IntermediateOperationsDemo {

	public static void main(String... args) {
		
		List<Integer> numbers = generateRandomNumbers();
		Stream<Integer> stream = numbers.stream();
		stream.filter(n -> n > 70)
		      .peek(n -> System.out.println("Raw mark: " + n))
		      .mapToInt(n -> n - 70)
		      .distinct()
		      .sorted()
		      .limit(10)
		      .forEach(n -> System.out.println("Score above A-grade threshold: " + n));
		
		System.out.println("Example of flatmap()");
		Stream<List<Integer>> intListStream = Stream.of(
		    Arrays.asList(1, 2), 
		    Arrays.asList(3, 4), 
		    Arrays.asList(5)
		);
		Stream<Integer> intStream = intListStream .flatMap((intList) -> intList.stream());
		intStream.forEach(System.out::println);
	}
	
	private static List<Integer> generateRandomNumbers() {
		Random r = new Random();
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 200; i++) {
			numbers.add(r.nextInt(100));
		}
		return numbers;
	}
}
