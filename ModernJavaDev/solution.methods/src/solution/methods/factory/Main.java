package solution.methods.factory;

public class Main {

	public static void main(String... args) {
		
		doSomeStuff(10, 5, VerboseLogger::new);
		doSomeStuff(20, 8, VerboseLogger::new);

		doSomeStuff(10, 5, BriefLogger::new);
		doSomeStuff(20, 8, BriefLogger::new);

		doSomeStuff(10, 5, null);
		doSomeStuff(20, 8, null);
	}
	
	private static void doSomeStuff(int n1, int n2, LoggerProvider lp) {
		
		Logger logger;
		if (lp == null) {
			logger = LoggerProvider.getNullLogger();
		}
		else {
			logger = lp.getLogger();
		}
		
		int a = n1 + n2;
		int b = n1 - n2;
		int c = n1 * n2;
		int d = n1 / n2;
		
		logger.log("Sum:  " + a);
		logger.log("Diff: " + b);
		logger.log("Prod: " + c);
		logger.log("Quot: " + d);
	}
}
