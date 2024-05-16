package demoSealedClasses.demo4;

// Notice there's no "permits" specifier in this example.
// The compiler assumes all permitted subclasses are in this compilation unit.
public sealed interface Shape  {
    double area();
    double perimeter();
}

// A class that extends/implements a sealed type must be qualified as final, sealed, or non-sealed.
// In the previous examples, Circle etc. were records. A record is implicitly final, so all good.
// In this example now, Circle is a class, so we must explicitly qualify as final, sealed, or non-sealed.
// Let's qualify it as final, to indicate nothing is allowed to inherit from Circle.
final class Circle implements Shape {

    private int x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public String toString() {
        return String.format("Circle[x=%d, y=%d, r=%d]", x, y, r);
    }
}

// Let's qualify Rectangle as non-sealed. This opens it up for unlimited subclass types.
non-sealed class Rectangle implements Shape {

    protected int x, y, w, h;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    @Override
    public double area() {
        return w * h;
    }

    @Override
    public double perimeter() {
        return 2 * (w + h);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[x=%d, y=%d, w=%d, h=%d]", x, y, w, h);
    }
}

// Let's define Square as a subclass of Rectangle. We'll qualify as final, so nothing will subclass Square.
class Square extends Rectangle {

    public Square(int x, int y, int w) {
        super(x, y, w, w);
    }

    @Override
    public String toString() {
        return String.format("Square[x=%d, y=%d, w=%d]", x, y, w);
    }
}

