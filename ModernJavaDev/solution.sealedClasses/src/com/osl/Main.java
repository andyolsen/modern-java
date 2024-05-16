package com.osl;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        step1();
        //step2();
    }

    private static void step1() {

        List<Contract> contracts = List.of(
                new FullTimer(27_000, LocalDate.of(2022, 12, 7)),
                new Consultant(300, LocalDate.of(2022, 1, 7)),
                new PartTimer(25, 14.99)
        );

        System.out.println("All contracts:");
        contracts.stream()
                 .forEach(System.out::println);

        System.out.println("\nAll contracts and effective annual salaries:");
        contracts.stream()
                .forEach(c -> processContract(c));
    }

    private static void processContract(Contract contract) {
        String preamble = switch (contract) {
            case FullTimer f -> "Full-time employee";
            case Consultant c -> "Consultant";
            case PartTimer p -> "Part-time employee";
        };
        System.out.printf("%s, effective annual salary %.2f\n", preamble, contract.getEffectiveSalary());
    }

    private static void step2() {

        List<Vehicle> vehicles = List.of(
                new Car("AAA 111", "Andy", 4),
                new LGV("BBB 222", "Jayne", 10_000),
                new HGV("CCC 333", "Em", 20_000),
                new CommercialVehicle("DDD 444", "Tom")
        );

        System.out.println("\nAll contracts and effective annual salaries:");
        vehicles.stream()
                .forEach(Main::processVehicle);
    }

    private static void processVehicle(Vehicle vehicle) {
        String preamble = switch (vehicle) {
            case Car c -> "Car";
            case LGV g -> "Light Goods vehicle";
            case HGV g -> "Heavy Goods vehicle";
            case CommercialVehicle m -> "Commercial vehicle";
        };
        System.out.printf("%s, %s\n", preamble, vehicle);
    }

}
