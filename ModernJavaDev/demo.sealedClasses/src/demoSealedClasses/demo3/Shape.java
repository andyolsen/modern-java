package demoSealedClasses.demo3;

// Notice there's no "permits" specifier in this example.
// The compiler assumes all permitted subclasses are in this compilation unit.
public sealed interface Shape {
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

record RightAngledTriangle(int b, int h) implements Shape {

    @Override
    public double area() {
        return 0.5 * b * h;
    }

    @Override
    public double perimeter() {
        return b + h + Math.hypot(b, h);
    }
}

