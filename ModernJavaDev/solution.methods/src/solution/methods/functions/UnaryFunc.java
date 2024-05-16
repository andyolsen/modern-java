package solution.methods.functions;

public interface UnaryFunc<T> {
	
	T perform(T operand);
	
	default String formatResult(T result) {
		return String.format("Result: %.6f", result);
	}
}
