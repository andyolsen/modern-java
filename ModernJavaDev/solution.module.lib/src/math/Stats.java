package math;

import io.ConsoleIO;

public class Stats {

    public static Result getResult() {

        double a = ConsoleIO.getNumber("Please enter 1st number: ");
        double b = ConsoleIO.getNumber("Please enter 2nd number: ");

        return new Result(
             a + b,
             a - b,
             a * b,
             a / b
        );
    }
}
