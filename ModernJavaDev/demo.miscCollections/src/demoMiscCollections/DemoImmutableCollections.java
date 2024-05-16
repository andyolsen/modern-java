package demoMiscCollections;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class DemoImmutableCollections {

    public static void doDemo() {

        System.out.println("\nIn DemoImmutableCollections");

        demoList();
        demoSet();
        demoMap();
    }

    private static void demoList() {

        List<String> list0 = List.of(); 
        display("Empty list", list0);

        List<String> list1 = List.of("andy"); 
        display("1-item list", list1);

        List<String> list2 = List.of("emily", "tom"); 
        display("2-item list", list2);

        List<String> list10 = List.of("Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid", "Donner", "Blitzen", "Rudolph", "Olive");
        display("10-item list", list10);

        List<String> listvariadic = List.of("ant", "bat", "cat", "dog", "elk", "fly", "gnu", "hippo", "iguana", "jaguar", "kangaroo", "lion", "noctule");
        display("variadic list", listvariadic);

        // An immutable list doesn't mean the same thing as a list of immutables...     
        List<Person> people = List.of(new Person("David", 21), new Person("Lydia", 30));
        people.get(0).age++;
        display("People", people); 
    }

    private static void demoSet() {

        Set<String> set0 = Set.of(); 
        display("Empty set", set0);

        Set<String> setNoDups = Set.of("hello", "goodbye"); 
        display("Set no dups", setNoDups);

        // This would cause a runtime error: java.lang.IllegalArgumentException: duplicate element: gwlad
        //		Set<String> setDups = Set.of("gwlad", "gwlad", "pleidiol", "wyf", "i'm", "wlad");
        //      display("Set dups", setDups);
    }

    private static void demoMap() {

        Map<Integer, String> map0 = Map.of(); 
        display("Empty map", map0);

        Map<String, Integer> mapItems = Map.of("UK", 44, "ES", 34, "NO", 47);
        display("Map with items", mapItems);
    }

    private static void display(String description, Object value) {
        System.out.printf("%s: %s\n", description, value);
    }
   
    private static void display(String message, Collection<?> collection) {
        System.out.println(message);
        collection.stream().forEach(System.out::println);        
        System.out.println();
    }
}

