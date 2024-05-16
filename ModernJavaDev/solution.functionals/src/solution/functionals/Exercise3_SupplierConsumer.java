package solution.functionals;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Exercise3_SupplierConsumer {

	public static void main(String... args) {

		// Create a NumberSource object (this object has several methods that supply an integer in various ways).
		NumberSource source = new NumberSource();
		
		// Call processValue() several times, passing in a Supplier<T> and a Consumer<T>.
		processValue(source::getSequentialNumber, Exercise3_SupplierConsumer::displayOnConsole);
		processValue(source::getSequentialNumber, Exercise3_SupplierConsumer::displayOnConsole);
		processValue(source::getSequentialNumber, Exercise3_SupplierConsumer::displayOnConsole);

		processValue(source::getRandomNumber, Exercise3_SupplierConsumer::displayOnConsole);
		processValue(source::getRandomNumber, Exercise3_SupplierConsumer::displayOnConsole);
		processValue(source::getRandomNumber, Exercise3_SupplierConsumer::displayOnConsole);

		processValue(source::getHourOfDay, Exercise3_SupplierConsumer::displayOnConsole);
		processValue(source::getHourOfDay, Exercise3_SupplierConsumer::displayOnConsole);
		processValue(source::getHourOfDay, Exercise3_SupplierConsumer::displayOnConsole);		
	}

	// Helper method, to consume a value (by displaying the value on the console).
	private static <T> void displayOnConsole(T value) {
		System.out.printf("[%s] Value %s\n", new Date(), value);
	}

	private static <T> void processValue(Supplier<T> supplier, Consumer<T> consumer) {
		T value = supplier.get();
		consumer.accept(value);
	}
}
