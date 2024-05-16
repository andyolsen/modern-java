package io;

import java.util.Scanner;

public class ConsoleIO {

    private static Scanner scanner = new Scanner(System.in);

    public static double getNumber(String promptMessage) {
        System.out.print(promptMessage);
        return scanner.nextDouble();
    }
}
