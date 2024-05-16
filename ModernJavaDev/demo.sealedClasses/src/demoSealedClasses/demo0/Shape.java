package demoSealedClasses.demo0;

// Imagine we want to limit the permitted classes that can inherit from Shape...
// In "traditional" Java, we could use a trick to do this...

abstract public class Shape {

    // Define a package-visibility constructor, as a "traditional" way to limit who can subclass.
    // Specifically, this will only permit subclasses to be defined in this package.
    Shape() {}
}

class Circle extends Shape {

    private int x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", x, y, r);
    }
}

class Rectangle extends Shape {

    private int x, y, h, w;

    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d %d", x, y, w, h);
    }
}
