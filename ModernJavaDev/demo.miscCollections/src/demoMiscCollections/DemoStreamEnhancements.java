package demoMiscCollections;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class DemoStreamEnhancements {

    public static void doDemo() {

        System.out.println("\nIn DemoStreamEnhancements");

        List<Person> list = List.of(
                new Person("Mary", 30),
                new Person("John", 35),
                new Person("Kate", 57),
                new Person("Rick", 56)
        );

        // Demo of takeWhile()
        System.out.println("People younger than 40, from the start:");
        list.stream()
                .takeWhile(p -> p.age < 40)
                .forEach(p -> System.out.printf("  %s\n", p));

        // Demo of dropWhile()
        System.out.println("People 40 or older, from the start:");
        list.stream()
                .dropWhile(p -> p.age < 40)
                .forEach(p -> System.out.printf("  %s\n", p));

        // Demo of iterate()
        Stream<Integer> numbers = Stream.iterate(
                1,
                     n -> n < 10_000,
                     n -> n * 2);
        System.out.println("Powers of 2, less than 10,000:");
        numbers.forEach(n -> System.out.printf("  %d\n", n));

        // Demo of ofNullable()
        Stream<Person> s1 = gimmeSafeStreamToAvoidNPE(new Person("Lewis", 44));
        System.out.printf("Size of s1 is %d\n", s1.count());

        Stream<Person> s2 = gimmeSafeStreamToAvoidNPE(null);
        System.out.printf("Size of s2 is %d\n", s2.count());
    }

    // This function might receive a null pointer, but it will always return a Stream.
    // This can help us to avoid NullPointerExceptions in our code.
    private static Stream<Person> gimmeSafeStreamToAvoidNPE(Person p) {
        return Stream.ofNullable(p);
    }
}
