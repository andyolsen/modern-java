package demo.lambda;

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class RosterTest {

    interface CheckMember {
        boolean test(Member p);
    }


    // Approach 1: Create Methods that Search for Members that Match One Characteristic.
    public static void printMembersOlderThan(List<Member> roster, int age) {
        for (Member p : roster) {
            if (p.getAge() >= age) {
                p.printMember();
            }
        }
    }

    // Approach 2: Create More Generalized Search Methods.
    public static void printMembersWithinAgeRange(
        List<Member> roster, int low, int high) {
        for (Member p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printMember();
            }
        }
    }

    // Approach 3: Specify Search Criteria Code in a Local Class.
    // Approach 4: Specify Search Criteria Code in an Anonymous Class.
    // Approach 5: Specify Search Criteria Code with a Lambda Expression.
    public static void printMembers(List<Member> roster, CheckMember tester) {
        for (Member p : roster) {
            if (tester.test(p)) {
                p.printMember();
            }
        }
    }

    // Approach 6: Use Standard Functional Interfaces with Lambda Expressions.
    public static void printMembersWithPredicate(List<Member> roster, Predicate<Member> tester) {
        for (Member p : roster) {
            if (tester.test(p)) {
                p.printMember();
            }
        }
    }

    // Approach 7: Use Lambda Expressions Throughout Your Application.
    public static void processMembers(List<Member> roster,
                                      Predicate<Member> tester,
                                      Consumer<Member> block) {
        for (Member p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    // Approach 7, second example.
    public static void processMembersWithFunction(List<Member> roster,
                                                  Predicate<Member> tester,
                                                  Function<Member, String> mapper,
                                                  Consumer<String> block) {
        for (Member p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void processMembersWithIterable(Iterable<Member> source,
                                                  Predicate<Member> tester,
                                                  Function<Member, String> mapper,
                                                  Consumer<Member> block) {
        for (Member p : source) {
            if (tester.test(p)) {
            	
                @SuppressWarnings("unused")
				String data = mapper.apply(p);

                block.accept(p);
            }
        }
    }

    public static <X, Y> void processElements(Iterable<X> source,
                                              Predicate<X> tester,
                                              Function<X, Y> mapper,
                                              Consumer<X> block) {
        for (X p : source) {
            if (tester.test(p)) {

                @SuppressWarnings("unused")
                Y data = mapper.apply(p);
                
                block.accept(p);
            }
        }
    }


    public static void main(String... args) {

        List<Member> roster = new ArrayList<>();
        roster.add(new Member("Fred", new GregorianCalendar(1980, 6, 20), Member.Sex.MALE,"fred@example.com"));
        roster.add(new Member("Jane", new GregorianCalendar(1990, 7, 15), Member.Sex.FEMALE, "jane@example.com"));
        roster.add(new Member("George", new GregorianCalendar(1991, 8, 13), Member.Sex.MALE, "george@example.com"));
        roster.add(new Member("Bob", new GregorianCalendar(2000, 9, 12), Member.Sex.MALE, "bob@example.com"));

        for (Member p : roster) {
            p.printMember();
        }

        // Approach 1: Create Methods that Search for Members that Match One Characteristic.
        System.out.println("Members older than 20:");
        printMembersOlderThan(roster, 20);

        // Approach 2: Create More Generalized Search Methods.
        System.out.println("\nMembers between the ages of 14 and 30:");
        printMembersWithinAgeRange(roster, 14, 30);

        // Approach 3: Specify Search Criteria Code in a Local Class.
        System.out.println("\nMembers who are eligible for Selective Service:");

        class CheckMemberEligibleForSelectiveService implements CheckMember {
           public boolean test(Member p) {
                return p.getGender() == Member.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25;
            }
        }
        printMembers(roster, new CheckMemberEligibleForSelectiveService());

        // Approach 4: Specify Search Criteria Code in an Anonymous Class.
        System.out.println("\nMembers who are eligible for Selective Service (anonymous class):");
        printMembers(roster,
                     new CheckMember() {
                         public boolean test(Member p) {
                             return p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
                         }
                     }
        );

        // Approach 5: Specify Search Criteria Code with a Lambda Expression.
        System.out.println("\nMembers who are eligible for Selective Service (lambda expression):");
        printMembers(roster, (Member p) -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

        // Approach 6: Use Standard Functional Interfaces with Lambda Expressions.
        System.out.println("\nMembers who are eligible for Selective Service (with Predicate parameter):");
        printMembersWithPredicate(roster, p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

        // Approach 7: Use Lamba Expressions Throughout Your Application.
        System.out.println("\nMembers who are eligible for Selective Service (with Predicate and Consumer parameters):");
        processMembers(roster,
                       p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                       p -> p.printMember()
        );

        // Approach 7, second example.
        System.out.println("\nMembers who are eligible for Selective Service (with Predicate, Function, and Consumer parameters):");
        processMembersWithFunction(roster,
                                   p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                                   p -> p.getEmailAddress(),
                                   email -> System.out.println(email)
        );

        // Preview of bulk data operations: example of how collections implement the Iterable interface.
        System.out.println("\nMembers who are eligible for Selective Service (with Iterable, Predicate, Function, and Consumer parameters):");
        processMembersWithIterable(roster,
                                   p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                                   p -> p.getEmailAddress(),
                                   email -> System.out.println(email)
        );

        // Preview of bulk data operations: Generic version of previous example.
        System.out.println("\nMembers who are eligible for Selective Service (generic version):");
        processElements(roster,
                        p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                        p -> p.getEmailAddress(),
                        email -> System.out.println(email)
        );

        // Preview of bulk data operations: Example of bulk data operations in use.
        System.out.println("\nMembers who are eligible for Selective Service (with bulk data operations):");
        roster.stream()
              .filter(p -> p.getGender() == Member.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
              .map(p -> p.getEmailAddress())
              .forEach(email -> System.out.println(email));
    }
}