package demoMiscLanguage;

import java.io.PrintStream;

public class DemoPrivateMethodsInInterfaces {

    public static void doDemo() {

        System.out.println("\nIn DemoPrivateMethodsInInterfaces");

        Logger logger = Logger.getConsoleLogger();
        logger.logInfo("This is an info message");
        logger.logWarning("This is a warning message");
        logger.logError("This is an error message");
    }
}

@FunctionalInterface
interface Logger {

    private void log(String prefix, String message) {
        PrintStream s = getStream();
        s.printf("%s %s\n", prefix, message);
    }

    default void logInfo(String message) {
        log("INFO:", message);
    }

    default void logWarning(String message) {
        log("WARNING:", message);
    }

    default void logError(String message) {
        log("ERROR:", message);
    }

    PrintStream getStream();

    static Logger getConsoleLogger() {
        // Return an object that implements the Logger interface.
        // Specifically, the object implements getStream() via a lambda.
        return () -> System.out;
    }
}