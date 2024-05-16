package com.osl;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        TemperatureReporter tempRep = new TemperatureReporterImpl();

        String menu = """
Choose an option:
1 - Get C
2 - Get F
3 - Get K
4 - Get all
5 - Quit
> """;

        while (true) {
            System.out.print(menu);
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: System.out.printf("%.2fC\n", tempRep.getCelsius());
                        break;

                case 2: System.out.printf("%.2fF\n", tempRep.getFahrenheit());
                        break;

                case 3: System.out.printf("%.2fK\n", tempRep.getKelvin());
                        break;

                case 4: System.out.printf("%s\n", tempRep.getFormattedString());
                        break;

                case 5: System.exit(0);
                        break;
            }             
        }
    }
}
