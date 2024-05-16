package demoPatternMatching;

public class D extends A {

    private int x;
    private double y;
    private String z;

    public D(int x, double y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Implementation of equals() using traditional instanceof tests.
    /*
    @Override
    public boolean equals(Object other) {

        if (!(other instanceof D))
            return false;

        D otherD = (D)other;

        return this.x == otherD.x &&
               this.y == otherD.y &&
               this.z.equals(otherD.z);
    }
    */

    // Implementation of equals() using pattern matching.
    /*
    @Override
    public boolean equals(Object other) {

        if (!(other instanceof D otherD))
            return false;

        // otherD is definitely assigned here, so we can still use it.
        return this.x == otherD.x &&
               this.y == otherD.y &&
               this.z.equals(otherD.z);
    }
    */

    // Implementation of equals() using pattern matching - more concise version.
    /*
    @Override
    public boolean equals(Object other) {
        // This is so beautiful I can hardly believe it.
        return other instanceof D otherD &&
               this.x == otherD.x &&
               this.y == otherD.y &&
               this.z.equals(otherD.z);
    }
    */
}
