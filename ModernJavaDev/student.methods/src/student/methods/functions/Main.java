package student.methods.functions;

public class Main {

	public static void main(String... args) {
		
		doOp(5.0, new Square());
		doOp(5.0, new Cube());		
	}
	
	private static <T> void doOp(T operand, UnaryFunc<T> func) {
		
		T result = func.perform(operand);

		String strResult = String.format("Result: %.6f", result);
		System.out.println(strResult);
	}
}
