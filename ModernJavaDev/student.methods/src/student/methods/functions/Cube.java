package student.methods.functions;

public class Cube implements UnaryFunc<Double> {

	@Override
	public Double perform(Double operand) {
		return operand * operand * operand;
	}
	
}
