package demoSealedClasses.demo0;

public class Main {

    public static void main(String[] args) {
        useShape(new Circle(10, 20, 5));
        useShape(new Rectangle(10, 20, 100, 200));
    }

    private static void useShape(Shape s) {
        switch (s) {
            case Circle c -> System.out.printf("It's a circle! %s\n", c);
            case Rectangle r -> System.out.printf("It's a rectangle! %s\n", r);

            // We need a default branch, because the compiler can't be sure about all possible subtypes.
            default -> System.out.printf("It's a shape Jim, but not as we know it! %s\n", s);
        }
    }
}
