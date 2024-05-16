package demoSealedClasses.demo5;

// You can't declare an already final class as sealed, because final effectively means "sealed with no subtypes".
// Add the "sealed" keyword to the following class, and see what happens...
final class MyFinalType {
}

// You can't declare an enum type as sealed, because it is already implicitly final.
// Add the "sealed" keyword to the following enum type, and see what happens...
enum NordicCountry {
    NORWAY, SWEDEN, FINLAND, DENMARK
}

// You can't declare a record as sealed, because it is already implicitly final.
// Add the "sealed" keyword to the following record, and see what happens...
record Point(int x, int y) {}

// You can't declare a functional interface as sealed.
// Add the "sealed" keyword to the following interface, and see what happens...
@FunctionalInterface
interface Command_V1<T> {
    void action(T t);
}

// You can't implement a sealed interface via an anonymous class, and lambdas don't count as subtypes either.
// Add the "sealed" keyword to the following interface, and see what happens down below in main()...
interface Command_V2<T> {
    void action(T t);
}

public class Main {

    public static void main(String[] args) {

        Command_V2<String> commandA = new Command_V2<String>() {
            public void action(String s) {
                System.out.printf("commandA, do something with %s\n", s);
            }
        };
        commandA.action("HELLO!");


        Command_V2<String> commandB = (String s) -> System.out.println(s);
        commandB.action("ADIEU!");
    }
}