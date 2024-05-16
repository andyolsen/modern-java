package packageServiceImpl;

import packageService.GreetingService;

public class GreetingServiceImpl implements GreetingService {

    public String getBriefGreeting() {
        return "Hi";
    }

    public String getVerboseGreeting() {
        return "Well hello by good chum!";
    }
}