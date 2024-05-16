package demoSealedClasses.demo2;

public sealed interface Shape permits Circle, Rectangle {
    double area();
    double perimeter();
}

record Circle(int x, int y, int r) implements Shape {

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * r;
    }
}

record Rectangle(int x, int y, int w, int h) implements Shape {

    @Override
    public double area() {
        return w * h;
    }

    @Override
    public double perimeter() {
        return 2 * (w + h);
    }
}
