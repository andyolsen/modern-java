package demo.functionals;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalsDemo {

	public static void main(String... args) {
		
		int magicNumber = 42;
	
		System.out.println("\nUsing Function<T,R> and UnaryOperator<T>");
		demoFunction(magicNumber, n -> n / 2);
		demoUnaryOperator(magicNumber, n -> n * 2);

		System.out.println("\nUsing BiFunction<T,U,R> and BinaryOperator<T>");
		demoBiFunction(10, 20, (v1, v2) -> v1 + v2);
		demoBinaryOperator(10, 20, (v1, v2) -> v1 - v2);

		System.out.println("\nUsing Predicate<T>");
		demoPredicate(magicNumber, n -> n == 42);
		demoPredicate(magicNumber, n -> n % 10 == 0);

		System.out.println("\nUsing Consumer<T>");
		demoConsumer(magicNumber, n -> System.out.println(n));
		demoConsumer(magicNumber, n -> System.out.println(n*n));

		System.out.println("\nUsing Supplier<T>");
		demoSupplier(() -> 180);
		demoSupplier(() -> new Random().nextInt(100));

	}
	
	private static <T, R> void demoFunction(T value, Function<T, R> theFunction) {
		R result = theFunction.apply(value);
		System.out.println("In demoFunction(), the result is " + result);
	}

	private static <T> void demoUnaryOperator(T value, UnaryOperator<T> theOperator) {
		T result = theOperator.apply(value);
		System.out.println("In demoUnaryOperator(), the result is " + result);
	}
	
	private static <T, U, R> void demoBiFunction(T value1, U value2, BiFunction<T,U,R> theFunction) {
		R result = theFunction.apply(value1, value2);
		System.out.println("In demoBiFunction(), the result is " + result);
	}
	
	private static <T> void demoBinaryOperator(T value1, T value2, BinaryOperator<T> theBinaryOperator) {
		T result = theBinaryOperator.apply(value1, value2);
		System.out.println("In demoBinaryOperator(), the result is " + result);
	}

	private static <T> void demoPredicate(T value, Predicate<T> thePredicate) {
		boolean result = thePredicate.test(value);
		System.out.println("In demoPredicate(), the result is " + result);
	}

	private static <T> void demoConsumer(T value, Consumer<T> theConsumer) {
		theConsumer.accept(value);
	}

	private static <T> void demoSupplier(Supplier<T> theSupplier) {
		T gottenValue = theSupplier.get();
		System.out.println("In demoSupplier(), the gotten value is " + gottenValue);
	}
}
