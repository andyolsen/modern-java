package com.osl;

import java.util.Optional;

public class Defect implements Comparable<Defect> {

    private final int severity;
    private final String description;

    public Defect(final int severity, final String description) {
        this.severity = severity;
        this.description = description;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Defect otherDefect) {
        return severity - otherDefect.severity;
    }

    @Override
    public String toString() {
        return String.format("[Severity %d]: %s", severity, description);
    }

    public static Optional<Defect> noDefect() {
        return Optional.of(new Defect(-1, "No Defect"));
    }
}