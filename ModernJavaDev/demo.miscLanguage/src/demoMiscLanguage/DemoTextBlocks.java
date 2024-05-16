package demoMiscLanguage;

public class DemoTextBlocks {

    public static void doDemo() {

        System.out.println("\nIn DemoTextBlocks");

        System.out.printf("""
Some great Welsh players of our time...
-\tGareth "Wales,Golf,Madrid" Bale
-\tAaron \"""Rambo\""" Ramsay
-\tJoe Allen
-\tLlanfairpwllgwyngyllgogerych\
wyrndrobwllllantysiliogogogoch man
-\t%s
""",
    "Andy Olsen");

    }
}
