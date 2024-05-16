package solution.methods.factory;

import java.util.Date;

public class VerboseLogger implements Logger {

	public VerboseLogger() {
		System.out.printf("\n*** Started VerboseLogger session at %s **********************\n", new Date());
	}
	
	@Override
	public void log(String message) {
		System.out.printf("[verbose message at %s] %s\n", new Date(), message);
	}
}
