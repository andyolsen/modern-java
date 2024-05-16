package packageServiceClient;

import java.util.ServiceLoader;
import java.util.Optional;
import java.util.NoSuchElementException;
import packageService.GreetingService;

public class Main {

    public static void main(String[] args) {

        Optional<GreetingService> optService = ServiceLoader.load(GreetingService.class)
                                                            .findFirst();
        try {
            GreetingService service = optService.get();
            System.out.println(service.getBriefGreeting());
            System.out.println(service.getVerboseGreeting());
        }
        catch (NoSuchElementException ex) {
            System.err.println("No GreetingService implementation available");
        }
    }
}