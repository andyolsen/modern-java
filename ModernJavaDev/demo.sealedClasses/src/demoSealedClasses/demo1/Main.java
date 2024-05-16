package demoSealedClasses.demo1;

public class Main {

    public static void main(String[] args) {
        useShape(new Circle(10, 20, 5));
        useShape(new Rectangle(10, 20, 100, 200));
    }

    private static void useShape(Shape s) {
        switch (s) {
            case Circle c    -> System.out.printf("It's a circle! %s\n", c);
            case Rectangle r -> System.out.printf("It's a rectangle! %s\n", r);
        }
    }
}
