package student.methods.factory;

public class Main {

	public static void main(String... args) {
		
		doSomeStuff(10, 5, "verbose");
		doSomeStuff(20, 8, "verbose");

		doSomeStuff(10, 5, "brief");
		doSomeStuff(20, 8, "brief");
	}
	
	private static void doSomeStuff(int n1, int n2, String loggerType) {
		
		Logger logger;
		
		if (loggerType.equals("verbose")) {
			logger = new VerboseLogger();
		}
		else {
			logger = new BriefLogger();
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
