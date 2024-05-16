package packageB;
import packageC.Greeting;

public class Main {

    public static void main(String[] args) {
        String message = Greeting.getMessage();
        System.out.println(message);
    }
}
