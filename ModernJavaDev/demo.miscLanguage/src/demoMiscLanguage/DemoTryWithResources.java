package demoMiscLanguage;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DemoTryWithResources {

    public static void doDemo() {

        System.out.println("\nIn DemoTryWithResources");

        try {
            String filename = String.format("%s/%s", System.getProperty("user.dir"), "Macbeth.txt");
            readFile_traditionalJava(filename);
            readFile_modernJava(filename);
        }
        catch (IOException ex) {
            System.err.println("Exception: " + ex.getMessage());
        }
    }

    private static void readFile_traditionalJava(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("Macbeth.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            } 
        } // Calls br.close() implicitly here.
    }

    private static void readFile_modernJava(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Macbeth.txt"));
        try (br) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            } 
        } // Calls br.close() implicitly here.
    }
}
