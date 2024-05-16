package solution.methods.factory;

import java.util.Date;

public class BriefLogger implements Logger {

	public BriefLogger() {
		System.out.printf("\n*** Started BriefLogger session at %s ************************\n", new Date());
	}
	
	@Override
	public void log(String message) {
		System.out.printf("%s\n", message);
	}
}
