package demoSealedClasses.demo1;

// Define a sealed interface. (It works the same way for sealed classes, btw).
public sealed interface Shape permits Circle, Rectangle {
}

