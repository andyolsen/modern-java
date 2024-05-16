package student.functionals;

import java.util.Date;

public class Exercise3_SupplierConsumer {

	public static void main(String... args) {

		// Create a NumberSource object (this object has several methods that supply an integer in various ways).
		NumberSource source = new NumberSource();

		// Call processValue() several times, passing in a Supplier<T> and a Consumer<T>.

		
	}


	// Helper method, to consume a value (by displaying the value on the console).
	private static <T> void displayOnConsole(T value) {
		System.out.printf("[%s] Value %s\n", new Date(), value);
	}

	
	// Implement processValue() here.



}
