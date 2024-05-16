package solution.functionals;

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
		System.out.println("Using compose()");
		doOp(30, sin.compose(log));
		doOp(30, sin.compose(log).compose(exp));
		
		System.out.println("\nUsing andThen()");
		doOp(30, sin.andThen(log));
		doOp(30, sin.andThen(log).andThen(exp));
		
		System.out.println("\nUsing compose() and andThen() in various combinations");
		doOp(30, sin.compose(log).andThen(exp));
		doOp(30, sin.andThen(log).compose(exp));
		doOp(30, sin.andThen(log).compose(exp).andThen(cos));
		doOp(30, sin.andThen(log).compose(exp).andThen(cos).compose(tan));
	}

	private static void doOp(double value, Function<Double, Double> op) {
		double result = op.apply(value);
		System.out.printf("%.4f\n", result);
	}
}
