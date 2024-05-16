package demo.lambda;

interface SomeInterface {
    void doIt(int arg);
}

public class LambdaScopeDemo {

    public int x = 0;

    public static void main(String... args) {
        LambdaScopeDemo obj = new LambdaScopeDemo();
        NestedClass n = obj.new NestedClass();
        n.methodInNestedClass(42);
    }


    class NestedClass {

        public int x = 1;

        void methodInNestedClass(int x) {
            
            // This statement would cause a compiler error at Statement A:
            //   "Local variable x defined in an enclosing scope must be final or effectively final"
            // x = 99;
            
            SomeInterface impl = y -> {
                
                // Do something with our parameter.
            	y++;
                
                // This statement would cause a compiler error here:
                //   "Lambda expression's local variable x cannot redeclare another local variable defined in an enclosing scope."
                // int x = 2;

                // We can access local variables that are final (or effectively final).        
                System.out.println("x = " + x);   				// Statement A (displays 42)
                
                // We can access our own lambda expression parameters, of course.
                System.out.println("y = " + y);   				
                
                // We can access any methods or variables in enclosing class, via the "this" keyword.
                System.out.println("this.x = " + this.x);		 
                this.anotherMethod();

                // And so on, for outer classes etc.
                System.out.println("LambdaScopeDemo.this.x = " + LambdaScopeDemo.this.x);
            };

            impl.doIt(x);
        }


        void anotherMethod() {
            int x = 180;
            System.out.println("anotherMethod() local x = " + x);
        }
    }
}