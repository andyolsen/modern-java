package demoSwitchUsage;


// See https://docs.oracle.com/en/java/javase/17/language/pattern-matching-switch-expressions-and-statements.html.
public class Main {

    public static void main(String[] args) {

        demoTraditionalSwitchStatements(1, 2024);

        demoSwitchStatementsWithMultipleCaseValues(2, 2024);
        demoSwitchStatementsWithArrowCaseLabels(3, 2024);

        demoSwitchExpressions(4, 2024);
        demoSwitchExpressionsYieldingValue_v1(5, 2024);
        demoSwitchExpressionsYieldingValue_v2(6, 2024);

        demoPatternMatching_if(new B());
        demoPatternMatching_switchStatement(new B());
        demoPatternMatching_switchExpression(new B());
    }

    private static void demoTraditionalSwitchStatements(int month, int year) {

        int daysInMonth;

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;

            case 2:
                daysInMonth = isLeapYear(year) ? 29 : 28;
                break;

            default:
                daysInMonth = 31;
                break;
        }

        System.out.printf("There are %d days in %02d/%04d\n", daysInMonth, month, year);
    }

    private static void demoSwitchStatementsWithMultipleCaseValues(int month, int year) {

        int daysInMonth;

        switch (month) {
            case 4, 6, 9, 11:
                daysInMonth = 30;
                break;

            case 2:
                daysInMonth = isLeapYear(year) ? 29 : 28;
                break;

            default:
                daysInMonth = 31;
                break;
        }
        System.out.printf("There are %d days in %02d/%04d\n", daysInMonth, month, year);
    }

    private static void demoSwitchStatementsWithArrowCaseLabels(int month, int year) {

        int daysInMonth;

        switch (month) {
            case 4, 6, 9, 11 -> daysInMonth = 30;
            case 2           -> daysInMonth = isLeapYear(year) ? 29 : 28;
            default          -> daysInMonth = 31;
        }

        System.out.printf("There are %d days in %02d/%04d\n", daysInMonth, month, year);
    }

    private static void demoSwitchExpressions(int month, int year) {

        int daysInMonth = switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2           -> isLeapYear(year) ? 29 : 28;
            default          -> 31;
        };

        System.out.printf("There are %d days in %02d/%04d\n", daysInMonth, month, year);
    }

    private static void demoSwitchExpressionsYieldingValue_v1(int month, int year) {

        int daysInMonth = switch (month) {
            case 4, 6, 9, 11 -> {
                System.out.print("Yay, it's April/June/Sept/Nov. ");
                yield 30;
            }
            case 2 -> {
                System.out.print("Yay, it's Feb. ");
                yield isLeapYear(year) ? 29 : 28;
            }
            default -> {
                System.out.print("Yay, it's Jan/Mar/May/July/Aug/Oct/Dec. ");
                yield 31;
            }
        };

        System.out.printf("There are %d days in %02d/%04d\n", daysInMonth, month, year);
    }

    private static void demoSwitchExpressionsYieldingValue_v2(int month, int year) {

        int daysInMonth = switch (month) {
            case 4, 6, 9, 11:
                System.out.print("Yay, it's April/June/Sept/Nov. ");
                yield 30;

            case 2:
                System.out.print("Yay, it's Feb. ");
                yield isLeapYear(year) ? 29 : 28;

            default:
                System.out.print("Yay, it's Jan/Mar/May/July/Aug/Oct/Dec. ");
                yield 31;
        };

        System.out.printf("There are %d days in %02d/%04d\n", daysInMonth, month, year);
    }

    private static void demoPatternMatching_if(A a) {

        System.out.println("Java 16 finalized support for pattern matching");

        if (a instanceof B b) {
            System.out.println("Got B object");
            b.m2();
        }
        else if (a instanceof C c) {
            System.out.println("Got C object");
            c.m3();
        }
        else {
            System.out.println("Got A object that isn't a B or C");
            a.m1();
        }
    }

    private static void demoPatternMatching_switchStatement(A a) {

        System.out.println("Java 17 has 'preview feature' support for pattern matching in a switch statement");

        switch (a) {
            case B b:
                System.out.println("Got B object");
                b.m2();
                break;

            case C c:
                System.out.println("Got C object");
                c.m3();
                break;

            default: // Note, branches must be exhaustive.
                System.out.println("Got A object that isn't a B or C");
                a.m1();
        }
    }

    private static void demoPatternMatching_switchExpression(A a) {

        System.out.println("Java 17 has 'preview feature' support for pattern matching in a switch expression");

        String str = switch (a) {
            case B b -> {
                b.m2();
                yield "Got B object";
            }

            case C c -> {
                c.m3();
                yield "Got C object";
            }

            default -> {
                a.m1();
                yield ("Got A object that isn't a B or C");
            }
        };
        System.out.println(str);
    }
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) ||
               (year % 400 == 0);
    }
}
