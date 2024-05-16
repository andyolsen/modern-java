package packageB;

import java.lang.module.ModuleDescriptor;
import packageC.Greeting;

public class Main {

    public static void main(String[] args) {
        String message = Greeting.getMessage();
        System.out.println(message);

        displayModuleInfoFor(Main.class);
        displayModuleInfoFor(Greeting.class);
    }

    private static void displayModuleInfoFor(Class aClass) {
        Module module = aClass.getModule();
        ModuleDescriptor descriptor = module.getDescriptor();
        System.out.printf("\nModule name: %s\n", descriptor.name());

        System.out.println("Exports packages:");
        descriptor
                .packages()
                .stream()
                .forEach(p -> System.out.printf("  %s\n", p));

        System.out.println("Requires modules:");
        descriptor
                .requires()
                .stream()
                .forEach(m -> System.out.printf("  %s\n", m));
    }
}