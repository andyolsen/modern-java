package packageZ;

import java.lang.module.ModuleDescriptor;
import packageX.ShortGreeting;
import packageY.LongGreeting;

public class Main {

    public static void main(String[] args) {
        System.out.println(ShortGreeting.getMessage());
        System.out.println(LongGreeting.getMessage());
    }
}