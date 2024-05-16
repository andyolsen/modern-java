package com.osl;

import java.time.Year;
import java.util.Scanner;

record Date(int day, int month, int year) {

    static Scanner scanner = new Scanner(System.in);

    public static Date fromUser() {
        // Get a date from the user.
        System.out.print("Day: ");
        int d = scanner.nextInt();

        System.out.print("Month: ");
        int m = scanner.nextInt();

        System.out.print("Year: ");
        int y = scanner.nextInt();

        return new Date(d, m, y);
    }

    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public boolean isValid() {
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 0 || year > 2099) {
            return false;
        }
        if (day < 1) {
            return  false;
        }

        int maxDay =  switch (month) {
            case 2 -> (isLeapYear()) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
        return day <= maxDay;
    }

    public String formattedDate() {

        String monthName = switch (month) {
            case 1  -> "January";
            case 2  -> "February";
            case 3  -> "March";
            case 4  -> "April";
            case 5  -> "May";
            case 6  -> "June";
            case 7  -> "July";
            case 8  -> "August";
            case 9  -> "September";
            case 10 -> "October";
            case 11 ->  "November";
            case 12 -> "December";
            default -> "Not Known";	 // Should never happen
        };

        String suffix = switch (day) {
            case 1, 21, 31 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            default -> "th";
        };

        return "" + day + suffix + " " + monthName + ", " + year;
    }
}

public class Main {

    public static void main(String[] args) {

        Date date = Date.fromUser();
        if (!date.isValid()) {
            System.out.println("Invalid date!");
        } else {
            String formattedDate = date.formattedDate();
            System.out.println("Valid date: " + formattedDate);
        }
    }
}
