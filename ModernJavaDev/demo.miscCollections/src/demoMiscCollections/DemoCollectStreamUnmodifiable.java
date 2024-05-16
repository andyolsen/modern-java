package demoMiscCollections;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DemoCollectStreamUnmodifiable {

    public static void doDemo() {

        System.out.println("\nIn DemoCollectStreamUnmodifiable");

        // Let's create a modifiable List first.
        List<Person> orig = new ArrayList<>();
        orig.add(new Person("Ola", 32));
        orig.add(new Person("Kari", 30));
        orig.add(new Person("Per", 20));
        orig.add(new Person("Hilde", 21));

        // Now let's collect into an unmodifiable list.
        List<Person> unmodifiable = orig.stream()
                                        .filter(p -> p.age >= 18)
                                        .collect(Collectors.toUnmodifiableList());

        System.out.println(unmodifiable.getClass().getName());
        // This would give an UnsupportedOperationException:
        // unmodifiable.add(new Person("Wiley Coyote", 10));

        // This is ok.
        unmodifiable.get(0).name = "Mr. Nordmann";
        unmodifiable.stream().forEach(System.out::println);
    }
}

