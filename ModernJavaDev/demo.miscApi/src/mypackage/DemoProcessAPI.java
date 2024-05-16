package mypackage;

import java.io.IOException;
import java.util.Optional;

public class DemoProcessAPI {

    public static void doDemo() {

        System.out.println("\nIn DemoProcessAPI");

        try {
            String processName = "notepad.exe";
            String commandLine = String.format("%s\\%s", System.getProperty("user.dir"), "Macbeth.txt");
            startProcess(processName, commandLine);
        }
        catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
        }
    }

    private static void startProcess(String processName, String commandLine) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder(processName, commandLine);
        Process process = processBuilder.start();
        ProcessHandle.Info info = process.info();

        display("Pid", process.pid());

        display("Command",     info.command());
        display("CommandLine", info.commandLine());
        display("User",        info.user());
        display("Start time",  info.startInstant());
    }

    private static void display(String description, Object value) {
        System.out.printf("%s: %s\n", description, value);
    }
   
    private static void display(String description, Optional<?> value) {
        if (value.isPresent()) 
            System.out.printf("%s: %s\n", description, value.get());
        else 
            System.out.printf("%s: not available\n", description);
    }
}
