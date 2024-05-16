package demoPatternMatching;

public class Main {

    public static void main(String[] args) {

        System.out.println("\ndemo1() shows traditional instanceof tests...");
        demo1(new B());
        demo1(new C());

        System.out.println("\ndemo2() shows pattern matching with instanceof tests...");
        demo2(new B());
        demo2(new C());

        System.out.println("\ndemo3() shows you can use a pattern variable anywhere it's 'definitely assigned'...");
        demo3(new B());
        demo3(new C());

        System.out.println("\ndemo3() shows you can use a pattern variable anywhere it's 'definitely assigned'...");
        demo3(new B());
        demo3(new C());

        System.out.println("\ndemo4a() and demo4b() further illustrate pattern variable scope...");
        demo4a(new B());
        demo4b(new B());

        System.out.println("\ndemo5() shows you can reuse pattern variables in different scopes...");
        demo5(new A());
        demo5(new B());
        demo5(new C());

        System.out.println("\ndemo6() uses equals() on an object...");
        demo6();
    }

    private static void demo1(A obj) {

        if (obj instanceof B) {
            System.out.println("Got a B object");
            B b = (B)obj;
            b.m2();
        }
        else {
            System.out.println("Got a non-B object");
        }
    }

    private static void demo2(A obj) {

        if (obj instanceof B b) {
            System.out.println("Got a B object");
            b.m2();
        }
        else {
            System.out.println("Got a non-B object");
        }
    }

    private static void demo3(A obj) {

        if (obj instanceof B b && b.someFlag) {
            System.out.println("Got a B object and someFlag is true");
            b.m2();
        }
        else {
            System.out.println("Got a non-B object");
            // Note that b is not in scope here, so we can't do this:
            // b.m2();
        }

        // You can't use b after the || (because the first test might fail...)
        // if (obj instanceof B b || b.someFlag) {
        //    System.out.println("We'll never know...");
        // }
    }

    private static void demo4a(A obj) {

        if (obj instanceof B b) {
            System.out.println("Got a B object, so I'm going to do something interesting...");
            b.m2();
            System.out.println("I've done something interesting...");
        }
        else {
            throw new RuntimeException("Whoa buddy, it's not a B!!!");
        }
    }

    // This approach is easier to understand.
    private static void demo4b(A obj) {

        if (!(obj instanceof B b)) {
            throw new RuntimeException("Whoa buddy, it's not a B!!!");
        }

        // We only get here if b IS instanceof B, i.e. we skipped the exception.
        // Pattern variables use the rule of "definitely assigned" to determine scope.
        System.out.println("Got a B object, so I'm going to do something interesting...");
        b.m2();
        System.out.println("I've done something interesting...");
    }

    private static void demo5(A obj) {

        // Note that we declare a pattern variable named x in each branch. This is fine.
        if (obj instanceof B x) {
            System.out.println("Got a B object");
            x.m2();
        }
        else if (obj instanceof C x) {
            System.out.println("Got a C object");
            x.m3();
        }
        else {
            System.out.println("Got an A that isn't a B or C");
            obj.m1();
        }
    }

    private static void demo6() {
        D d1 = new D(1, 3.14, "wibble");

        D d2 = new D(1, 3.14, "wibble");
        System.out.printf("d1 equals d2: %s\n", d1.equals(d2));

        D d3 = new D(42, 9.99, "llanfairpwll");
        System.out.printf("d1 equals d3: %s\n", d1.equals(d3));

        A a = new A();
        System.out.printf("d1 equals a: %s\n", d1.equals(a));
    }
}
