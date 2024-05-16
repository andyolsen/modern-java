package solution.methods.functions;

public class DistanceConverter {
	
	private static final double KM_TO_MILES = 0.62137;	// 1km = 0.62137 miles.
	
	static double kmToMiles(double km) {
		return km * KM_TO_MILES;
	}

	static double milesToKm(double miles) {
		return miles / KM_TO_MILES;
	}
}
