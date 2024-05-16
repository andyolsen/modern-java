package solution.methods.functions;

public class Main {

	public static void main(String... args) {
		
		doOp(5.0, new Square());
		doOp(5.0, new Cube());
		
		doOp(5.0, DistanceConverter::kmToMiles);
		doOp(5.0, DistanceConverter::milesToKm);

		doOp(5.0, WeightConverter::kgToPounds);
		doOp(5.0, WeightConverter::poundsToKg);
	}
	
	private static <T> void doOp(T operand, UnaryFunc<T> func) {
		
		T result = func.perform(operand);

		String strResult = func.formatResult(result);
		System.out.println(strResult);
	}
}
