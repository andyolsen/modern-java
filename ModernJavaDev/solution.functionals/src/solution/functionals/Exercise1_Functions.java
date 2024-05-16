package solution.functionals;

import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Exercise1_Functions {

	public static void main(String... args) {

		// Create a Calculator object (this object has several mathematical operations).
		Calculator calc = new Calculator(Calculator.AngleType.DEGREES);

		// Call doOp() several times, passing in a double value and a Function<Double,Double>.
		System.out.println("Using Function<T,R>");
		doOp(30.0, calc::sin);
		doOp(30.0, calc::cos);
		doOp(30.0, calc::tan);
		doOp(30.0, calc::log);
		doOp(30.0, calc::exp);
		
		// Call doOpUsingUnaryOperator() several times, passing in a double value and a UnaryOperator<Double>.
		System.out.println("\nUsing UnaryOperator<T>");
		doOpUsingUnaryOperator(30.0, calc::sin);
		doOpUsingUnaryOperator(30.0, calc::cos);
		doOpUsingUnaryOperator(30.0, calc::tan);
		doOpUsingUnaryOperator(30.0, calc::log);
		doOpUsingUnaryOperator(30.0, calc::exp);
		
		// Call doOpUsingDoubleUnaryOperator() several times, passing in a double value and a DoubleUnaryOperator.
		System.out.println("\nUsing DoubleUnaryOperator");
		doOpUsingDoubleUnaryOperator(30.0, calc::sin);
		doOpUsingDoubleUnaryOperator(30.0, calc::cos);
		doOpUsingDoubleUnaryOperator(30.0, calc::tan);
		doOpUsingDoubleUnaryOperator(30.0, calc::log);
		doOpUsingDoubleUnaryOperator(30.0, calc::exp);		
	}

	private static <T,R> void doOp(T value, Function<T, R> op) {
		R result = op.apply(value);
		System.out.printf("%s\n", result);
	}
	
	private static <T> void doOpUsingUnaryOperator(T value, UnaryOperator<T> op) {
		T result = op.apply(value);
		System.out.printf("%s\n", result);
	}	
	
	private static void doOpUsingDoubleUnaryOperator(double value, DoubleUnaryOperator op) {
		double result = op.applyAsDouble(value);
		System.out.printf("%s\n", result);
	}	
}
