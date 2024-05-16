package student.functionals;

import java.util.function.Function;

public class Exercise4_ComposedFunctions {

	public static void main(String... args) {

		// Create a Calculator object (this object has several mathematical operations).
		Calculator calc = new Calculator(Calculator.AngleType.DEGREES);

		// Create several Function<Double, Double> objects, to represent various methods on the Calculator instance. 
		Function<Double, Double> sin = calc::sin;
		Function<Double, Double> cos = calc::cos;
		Function<Double, Double> tan = calc::tan;
		Function<Double, Double> log = calc::log;
		Function<Double, Double> exp = calc::exp;
		
		// Combine Function<T,T> operations in various ways, by using compose() and andThen(). 

	}

	
	private static void doOp(double value, Function<Double, Double> op) {
		double result = op.apply(value);
		System.out.printf("%.4f\n", result);
	}
}
