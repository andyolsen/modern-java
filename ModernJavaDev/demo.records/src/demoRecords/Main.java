package demoRecords;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.RecordComponent;

public class Main {

    public static void main(String [] args) {

        demoUsingRecord();
        demoUsingClass();

        demoUsingCustomConstructors();
        demoUsingOverriddenMethods();
        demoUsingRecordThatHasAdditionalMembers();

        demoUsingRecordThatImplementsInterface();
        demoUsingRecordThatImplementsSerializable();

        demoUsingGenericRecord();
        demoUsingReflection();
        demoUsingAnnotations();
    }

    private static void demoUsingRecord() {

        System.out.println("\ndemoUsingRecords()");

        var p1 = new PersonR(1234, "Andy", "Welsh", 58);
        System.out.printf("%s, nationality: %s, age : %d\n", p1.name(), p1.nationality(), p1.age());
        System.out.printf("p1.toString(): %s\n", p1.toString());
        System.out.printf("p1.hashCode(): %d\n", p1.hashCode());

        var p2 = new PersonR(1234, "Andy", "Welsh", 58);
        System.out.printf("p1.equals(p2)? %s\n", p1.equals(p2));
    }

    private static void demoUsingClass() {

        System.out.println("\ndemoUsingClasses()");

        var p1 = new PersonC(1234, "Andy", "Welsh", 58);
        System.out.printf("%s, nationality: %s, age : %d\n", p1.name(), p1.nationality(), p1.age());
        System.out.printf("p1.toString(): %s\n", p1.toString());
        System.out.printf("p1.hashCode(): %d\n", p1.hashCode());

        var p2 = new PersonC(1234, "Andy", "Welsh", 58);
        System.out.printf("p1.equals(p2)? %s\n", p1.equals(p2));
    }

    private static void demoUsingCustomConstructors() {

        System.out.println("\ndemoUsingCustomConstructors()");

        try {
            var p1 = new PersonR_CustomConstructor_V1(1234, "John Smith", "English", -1);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            var p2 = new PersonR_CustomConstructor_V2(1234, "Jane Smith", "English", -1);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        var p3a = new PersonR_CustomConstructor_V3(1234, "John Smith", "English", 21);
        var p3b = new PersonR_CustomConstructor_V3(1234, "Jane", "Smith", "English", 25);
        System.out.println(p3a);
        System.out.println(p3b);
    }

    private static void demoUsingOverriddenMethods() {

        System.out.println("\ndemoUsingOverriddenMethods()");

        var p1 = new PersonR_OverridingMethods(1234, "Andrew", "Welsh", 58);
        var p2 = new PersonR_OverridingMethods(1234, "Andy", "Welsh", 58);

        System.out.println(p1.toString());
        System.out.println(p2);
        System.out.printf("p1.equals(p2)? %s\n", p1.equals(p2));
        System.out.printf("p1.hashCode(): %d\n", p1.hashCode());
        System.out.printf("p2.hashCode(): %d\n", p2.hashCode());
    }

    private static void demoUsingRecordThatHasAdditionalMembers() {

        System.out.println("\ndemoUsingRecordThatHasAdditionalMembers()");

        var p0 = PointR_AdditionalMembers.getOrigin();
        var p1 = new PointR_AdditionalMembers(10, 20);
        var p2 = p1.getPointReflectedInXAxis();
        var p3 = p1.getPointReflectedInYAxis();

        System.out.println(p0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.printf("Point granularity is %.4f\n", PointR_AdditionalMembers.granularity);
    }

    private static void demoUsingRecordThatImplementsInterface() {

        System.out.println("\ndemoUsingRecordThatImplementsInterface()");

        Loggable p1 = new PointR_ImplementsInterface(10, 20);
        p1.log();
    }

    private static void demoUsingRecordThatImplementsSerializable() {

        System.out.println("\ndemoUsingRecordThatImplementsSerializable()");

        var p1 = new PointR_ImplementsSerializable(10, 20);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("point.txt"))) {
            oos.writeObject(p1);

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("point.txt"))) {
                var p2 = (PointR_ImplementsSerializable) ois.readObject();
                System.out.println(p2);
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void demoUsingGenericRecord() {

        System.out.println("\ndemoUsingGenericRecord()");

        var p1 = new PointR_Generic(10, 20);
        System.out.println(p1);

        var p2 = new PointR_Generic(10.5, 21.5);
        System.out.println(p2);

        var p3 = new PointR_Generic(10, 21.5);
        System.out.println(p3);
    }

    private static void demoUsingReflection() {

        System.out.println("\ndemoUsingReflection()");

        var p1 = new PointR_Reflection(10, 20);

        Constructor[] ctors = p1.getClass().getConstructors();
        System.out.printf("Constructors for %s:\n", p1.getClass().getName());

        for (var c : ctors) {
            System.out.println(c);

            Parameter[] params = c.getParameters();
            for (var p: params) {
                System.out.printf("  Parameter type %s\n", p.getType());
            }
        }

        if (p1.getClass().isRecord()) {
            System.out.println("p1 is a record with the following components (i.e. fields):");
            RecordComponent[] components = p1.getClass().getRecordComponents();
            for (var c : components) {
                System.out.printf("  %s\n", c);
            }
        }
    }

    private static void demoUsingAnnotations() {

        System.out.println("\ndemoUsingAnnotations()");

        var p1 = new PointR_WithAnnotations(10, 20, 30);

        if (p1.getClass().isRecord()) {
            System.out.println("p1 is a record with the following components (i.e. fields:");
            RecordComponent[] components = p1.getClass().getRecordComponents();
            for (var c : components) {
                MyAnnotation a = c.getAnnotation(MyAnnotation.class);
                if (a != null)
                    System.out.printf("  %s has MyAnnotation value=%s\n", c, a.value());
                else
                    System.out.printf("  %s doesn't have MyAnnotation\n", c);
            }
        }
    }
}
