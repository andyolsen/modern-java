package demoMiscLanguage;

abstract class MyBox<T> {
    protected T state;
    public MyBox(T state) {
        this.state = state;
    }
    abstract void action();
}

public class DemoDiamondOperator {

    public static void doDemo() {

        System.out.println("\nIn DemoDiamondOperator");

        anonImpl_traditionalJava();
        anonImpl_modernJava();
    }

    private static void anonImpl_traditionalJava() {

        MyBox<String> strbox = new MyBox<String>("Greetings") {
            @Override
            public void action() {
                System.out.println(state);
            }
        };
        strbox.action();
    }

    private static void anonImpl_modernJava() {

        MyBox<String> strbox = new MyBox<>("Earthling") {
            @Override
            public void action() {
                System.out.println(state);
            }
        };
        strbox.action();
    }
}

