package demoMiscLanguage;

import java.util.List;

public class DemoLambdaParameterTypeInference {

    public static void doDemo() {

        System.out.println("\nIn DemoLambdaParameterTypeInference");

        List<String> ducklings = List.of("Huey", "Louis", "Dewey");

        ducklings.stream()
                 .forEach(s -> System.out.println(s));

        ducklings.stream()
                 .forEach((@NotNull var s) -> System.out.println(s));
    }
}

// Dummy version of NotNull annotation.
@interface NotNull {}