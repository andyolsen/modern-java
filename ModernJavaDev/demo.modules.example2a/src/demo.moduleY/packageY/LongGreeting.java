package packageY;

import packageX.ShortGreeting;

public class LongGreeting {

    public static String getMessage() {
        return ShortGreeting.getMessage() + "World";
    }
}