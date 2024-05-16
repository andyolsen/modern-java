package solution.methods.functions;

public class Square implements UnaryFunc<Double> {

	@Override
	public Double perform(Double operand) {
		return operand * operand;
	}
	
	@Override
	public String formatResult(Double result) {
		return String.format("Square result: %.6f", result);
	}
}
