package solution.methods.functions;

public class WeightConverter {
	
	private static final double KG_TO_POUNDS = 2.20462;	// 1kg = 2.20462 pounds.
	
	static double kgToPounds(double kg) {
		return kg * KG_TO_POUNDS;
	}

	static double poundsToKg(double pounds) {
		return pounds / KG_TO_POUNDS;
	}
}
