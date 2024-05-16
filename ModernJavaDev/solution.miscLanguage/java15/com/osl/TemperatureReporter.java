package com.osl;

public interface TemperatureReporter {

    private double generateRandomTemperature() {
        return (Math.random() * 200) - 100;
    }

    default double getCelsius() {
        return generateRandomTemperature();
    }

    default double getFahrenheit() {
        double c = generateRandomTemperature();
        return 32.0 + (c * 9.0 / 5.0);
    }

    default double getKelvin() {
        double c = generateRandomTemperature();
        return c + 273;
    }

    String getFormattedString();
}
