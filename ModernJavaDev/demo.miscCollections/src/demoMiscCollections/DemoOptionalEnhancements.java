package demoMiscCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DemoOptionalEnhancements {

    public static void doDemo() {

        System.out.println("\nIn DemoOptionalEnhancements");

        List<Optional<Person>> optPersons = new ArrayList<>();
        optPersons.add(Optional.of(new Person("Ole", 4)));
        optPersons.add(Optional.empty());
        optPersons.add(Optional.of(new Person("Dole", 5)));
        optPersons.add(Optional.empty());
        optPersons.add(Optional.of(new Person("Doffen", 6)));

        // Demo of stream()
        System.out.println("Getting a (0 or 1 element) stream from Optional");
        optPersons
                .stream()
//                .peek(op -> System.out.printf("  peeking %s\n", op))
                .map(op -> op.stream())
                .forEach(s -> System.out.printf("  printing %d\n", s.count()));

        System.out.println("Transforming a stream of optional elements to a Stream of present-value elements");
        optPersons
                .stream()
//                .peek(op -> System.out.printf("  peeking %s\n", op))
                .flatMap(op -> op.stream())
                .forEach(p -> System.out.printf("  printing %s\n", p));

        // Demo of ifPresentOrElse()
        Optional<Person> op1 = Optional.of(new Person("Jayne", 57));
        op1.ifPresentOrElse(
                p -> System.out.println(p),
                () -> System.out.println("No value dude")
        );

        Optional<Person> op2 = Optional.empty();
        op2.ifPresentOrElse(
                p -> System.out.println(p),
                () -> System.out.println("No value dude")
        );

        // Demo of or().
        Optional<Person> op3 = Optional.of(new Person("Andy", 58));
        Person p3 = op3.or(() -> Optional.of(new Person("DUMMY NAME", 21))).get();
        System.out.println(p3);

        Optional<Person> op4 = Optional.empty();
        Person p4 = op4.or(() -> Optional.of(new Person("DUMMY NAME", 21))).get();
        System.out.println(p4);
    }
}