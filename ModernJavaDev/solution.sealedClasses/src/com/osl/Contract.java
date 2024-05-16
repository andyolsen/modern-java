package com.osl;

import java.time.LocalDate;

public sealed interface Contract {
    double getEffectiveSalary();
}

record FullTimer(double annualSalary, LocalDate reviewDate) implements Contract {

    @Override
    public double getEffectiveSalary() {
        return annualSalary;
    }
}

record PartTimer(int hoursPerWeek, double hourlyRate) implements Contract {

    private static int WORKING_WEEKS_PER_YEAR = 48;

    @Override
    public double getEffectiveSalary() {
        return WORKING_WEEKS_PER_YEAR * hoursPerWeek * hourlyRate;
    }
}

record Consultant(double dailyRate, LocalDate renewalDate) implements Contract {

    private static int WORKING_DAYS_PER_YEAR = 240;

    @Override
    public double getEffectiveSalary() {
        return WORKING_DAYS_PER_YEAR * dailyRate;
    }
}