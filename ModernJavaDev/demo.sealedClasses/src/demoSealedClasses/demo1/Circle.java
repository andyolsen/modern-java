package demoSealedClasses.demo1;

// Implement the permitted subtypes...
// We've defined as records here, but we could have defined as regular classes instead.
record Circle(int x, int y, int r) implements Shape {
}
