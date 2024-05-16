package com.osl;

public class TemperatureReporterImpl implements TemperatureReporter {

    public String getFormattedString() {
        return String.format(
                   "JAVA 17 TEMPERATURE REPORTER! Temperatures %.2fC, %.2fF, %.2fK", 
                   getCelsius(),
                   getFahrenheit(),
                   getKelvin());
    }
}
