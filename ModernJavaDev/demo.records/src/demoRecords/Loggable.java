package demoRecords;

import java.io.PrintStream;

public interface Loggable {
    void log();
    default PrintStream getStream() {
        return System.out;
    }
}
