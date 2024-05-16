package solution.functionals;

import java.util.function.Predicate;

public class Exercise2_Predicates {

	public static void main(String... args) {

		// Create some Predicate<Integer> objects.
		Predicate<Integer> test1 = n -> n >= 18;
		Predicate<Integer> test2 = n -> n < 65;
		Predicate<Integer> test3 = n -> n >= 100;

		// Pass the predicates into methods.
		doTest(70, test1);
		doTest(70, test2);
		
		doNotTest(70, test1);
		doNotTest(70, test2);

		doAndTests(60, test1, test2);
		doAndTests(70, test1, test2);

		doOrTests(60, test2, test3);
		doOrTests(70, test2, test3);
		doOrTests(120, test2, test3);
	}

	private static <T> void doTest(T value, Predicate<T> p) {
		boolean result = p.test(value);
		System.out.printf("doTest(%s): %s\n", value, result);
	}
	
	private static <T> void doNotTest(T value, Predicate<T> p) {
		boolean result = p.negate().test(value);
		System.out.printf("doNotTest(%s): %s\n", value, result);
	}
	
	private static <T> void doAndTests(T value, Predicate<T> p1, Predicate<T> p2) {
		boolean result = p1.and(p2).test(value);
		System.out.printf("doAndTest(%s): %s\n", value, result);
	}
	
	private static <T> void doOrTests(T value, Predicate<T> p1, Predicate<T> p2) {
		boolean result = p1.or(p2).test(value);
		System.out.printf("doOrTest(%s): %s\n", value, result);
	}	
}
