package demoSealedClasses.demo4;

public class Main {

    public static void main(String[] args) {
        useShape(new Circle(10, 20, 5));
        useShape(new Rectangle(10, 20, 100, 200));
        useShape(new Square(10, 20, 100));
    }

    private static void useShape(Shape s) {
        String preamble = switch (s) {
            case Circle c    -> "It's a circle!";
            case Square sq   -> "It's a square!";
            case Rectangle r -> "It's a rectangle!";
        };
        System.out.printf("%s, area %.2f, perimeter %.2f\n", preamble, s.area(), s.perimeter());
    }
}
