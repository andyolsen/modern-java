package student.methods.functions;

public class Square implements UnaryFunc<Double> {

	@Override
	public Double perform(Double operand) {
		return operand * operand;
	}
	
}
