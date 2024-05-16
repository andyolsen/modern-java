package com.osl;

import java.time.Year;

public class Main {

    public static void main(String[] args) {

        // Create a Builder object and feed in the field values we're interested in.
        Book.Builder builder = new Book.Builder()
                .title("When the Lion Feeds")
                .genre("adventure")
                .author("Wilbur Smith")
                .published(Year.of(1980));

        // Create a book object, by using the builder.
        Book book1 = builder.build();
        System.out.println(book1);

        // Create another book with slightly different details, reusing the same Builder instance.
        Book book2 = builder.title("The Sound of Thunder")
                            .published(Year.of(1982))
                            .build();
        System.out.println(book2);
    }
}
