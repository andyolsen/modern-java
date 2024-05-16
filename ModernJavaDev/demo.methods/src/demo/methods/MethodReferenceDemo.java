package demo.methods;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReferenceDemo {
    
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Lukasz Fabianski", 30, false),
                new Person("Neil Taylor", 26, true),
                new Person("Angel Rangel", 32, false),
                new Person("Ashley Williams", 30, true));
        
    	// Example 1.
    	System.out.println("Example 1: Refer to a static method.");
    	Collections.sort(people, Person::myStaticCompare);
        displayList("People sorted by name", people);

    	// Example 2.
    	System.out.println("\nExample 2: Refer to an instance method.");
    	Collections.sort(people, Person::myInstanceCompare);
        displayList("People sorted by age", people);

    	// Example 3.
    	System.out.println("\nExample 3: Using primitives.");
    	List<Integer> lotto = Arrays.asList(19, 1, 3, 12, 2, 7, 5, 10);
        Collections.sort(lotto, Integer::compareTo);
        displayList("Lottery numbers in ascending order", lotto);
    }
        
    private static <T> void displayList(String msg, List<T> items) {
        System.out.println(msg);
        for (T item : items) {
            System.out.println("    " + item);
        }
    }
}

