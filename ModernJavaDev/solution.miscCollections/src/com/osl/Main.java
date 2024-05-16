package com.osl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        var numbers = new HashSet<Integer>();
        while (numbers.size() < 20) {
            numbers.add(Math.toIntExact(Math.round(Math.random() * 100)));
        }

        final var defects = new ArrayList<Defect>();
        numbers.forEach(n -> defects.add(new Defect(n, String.format("I'm a defect with severity %d", n))));

        List<Defect> fixedSortedList = defects
                .stream()
                .sorted()
                .toList();   // Note, toList() calls collect(Collectors.toUnmodifiableList()) so it's equivalent.

        System.out.println("\nDefects < 50");
        fixedSortedList
                .stream()
                .takeWhile(d -> d.getSeverity() < 50)
                .forEach(System.out::println);

        System.out.println("\nDefects >= 50");
        fixedSortedList
                .stream()
                .dropWhile(d -> d.getSeverity() < 50)
                .forEach(System.out::println);

        System.out.println("\nDefect with lowest severity or none");
        Defect minDefect = fixedSortedList
                .stream()
                .min(Defect::compareTo)
                .or(() -> Defect.noDefect())
                .get();
        System.out.println(minDefect);
    }
}