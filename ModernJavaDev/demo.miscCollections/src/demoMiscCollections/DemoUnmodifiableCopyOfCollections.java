package demoMiscCollections;

import java.util.List;
import java.util.ArrayList;

public class DemoUnmodifiableCopyOfCollections {

    public static void doDemo() {

        System.out.println("\nIn DemoUnmodifiableCopyOfCollections");

        // Let's create a modifiable List first.
        List<Person> orig = new ArrayList<>();
        orig.add(new Person("Ola", 32));
        orig.add(new Person("Kari", 30));

        // Create an unmodifiable copy, i.e. a collection that we can't add/remove items.
        List<Person> copy = List.copyOf(orig);

        // We can change state of items in original list.    
        // The "copy" collection will see the state changes in the items.
        orig.get(0).age++;
        copy.stream().forEach(System.out::println);

        // We can add items to original list.
        // The "copy" collection won't see the new items.
        orig.add(new Person("Per", 21));
        orig.add(new Person("Hilde", 22));
        copy.stream().forEach(System.out::println);
    }
}