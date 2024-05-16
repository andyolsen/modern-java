package demo.methods;

interface ParentInterface {
    void method1(int i);
    void method2(double d);
    default void method3(String s) {
        System.out.println("ParentInterface.method3 received " + s);
    }
}

class ChildClass implements ParentInterface {
    
    // Normal stuff in a class...
    
    // Must override method1().
    @Override
    public void method1(int i) {
        System.out.println("ChildClass.method1 received " + i);
    }

    // Must override method2().
    @Override
    public void method2(double d) {
        System.out.println("ChildClass.method2 received " + d);
    }

    // Optionally, can override method3().
    @Override
    public void method3(String s) {
        System.out.println("ChildClass.method3 received " + s);
        ParentInterface.super.method3(s);
    }
}

// ----------------------------------------------------------------------------------------
// Special case 2.
//----------------------------------------------------------------------------------------
interface MyInterface {
    void m1();
    void m2();
    default void m3() {
        System.out.println("MyInterface.m3");
    }
}

class MyClass {
    
    public void mA() {
        System.out.println("MyClass.mA");
    }
    
    public void mB() {
        System.out.println("MyClass.mB");
    }
    
    public void m3() {
        System.out.println("MyClass.m3");
    }
}

class MyOtherClass extends MyClass implements MyInterface {
    
    @Override
    public void m1() {
        System.out.println("MyOtherClass.m1");
    }
    
    @Override
    public void m2() {
        System.out.println("MyOtherClass.m2");
    }
}

//----------------------------------------------------------------------------------------
// Special case 3.
//----------------------------------------------------------------------------------------
interface MyInterface1 {
    void m1();
    void m2();
    default void m3() {
        System.out.println("MyInterface1.m3");
    }
}

interface MyInterface2 {
    void mA();
    void mB();
    default void m3() {
        System.out.println("MyInterface2.m3");
    }
}

class MyAnotherClass implements MyInterface1, MyInterface2 {

    @Override
    public void m1() {
        System.out.println("MyAnotherClass.m1");
    }
    
    @Override
    public void m2() {
        System.out.println("MyAnotherClass.m2");
    }

    @Override
    public void mA() {
        System.out.println("MyAnotherClass.mA");
    }
    
    @Override
    public void mB() {
        System.out.println("MyAnotherClass.mB");
    }
    
    // If you comment-out the following implementation of m3(), you'll get a compiler error:
    // "Duplicate default methods named m3 with the parameters () and () are inherited from the types MyInterface2 and MyInterface1".
    @Override
    public void m3() {
        MyInterface1.super.m3();
        MyInterface2.super.m3();
    }
}

public class DefaultMethodDemo {
    
    public static void main(String[] args) {

        ChildClass obj = new ChildClass();
        obj.method1(42);
        obj.method2(3.14);
        obj.method3("banana");
        
        MyOtherClass otherObj = new MyOtherClass();
        otherObj.m3();
        
        MyAnotherClass anotherObj = new MyAnotherClass();
        anotherObj.m3();
    }
}

