package solution.methods.functions;

public class Cube implements UnaryFunc<Double> {

	@Override
	public Double perform(Double operand) {
		return operand * operand * operand;
	}
	
	@Override
	public String formatResult(Double result) {
		return String.format("Cube result: %.6f", result);
	}
}
