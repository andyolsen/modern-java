package demoSealedClasses.demo2;

public class Main {

    public static void main(String[] args) {
        useShape(new Circle(10, 20, 5));
        useShape(new Rectangle(10, 20, 100, 200));
    }

    private static void useShape(Shape s) {
        System.out.printf("%s, area %.2f, perimeter %.2f\n", s, s.area(), s.perimeter());
    }
}
