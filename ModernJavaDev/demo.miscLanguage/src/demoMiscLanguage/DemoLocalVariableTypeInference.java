package demoMiscLanguage;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MyUnaryOperator {
    int apply(int n);
}

public class DemoLocalVariableTypeInference {

    public static void doDemo() {

        System.out.println("\nIn DemoLocalVariableTypeInference");

        var x = 42.99;
        var y = x + 1;
        var z = x / 42;

        var num = 42;
        var strList = new ArrayList<String>();

        var objList = new ArrayList<>();
        var numList = List.of(10, 20, 30, 10.5, 20.5, 30.5);

        System.out.printf("num is type %s\n", ((Object)num).getClass().getName());
        System.out.printf("strList is type %s\n", strList.getClass().getName());
        System.out.printf("objList is type %s\n", objList.getClass().getName());
        System.out.printf("numList is type %s\n", numList.getClass().getName());

        // Error: Can't reassign incompatible value.
        // num = "Wibble";

        // Error: Can't omit initialization.
        // var whatOnEarthAmI;
        // whatOnEarthAmI = "It's too late now, dude";

        // Error: Can't initialize with null.
        // var somethingThatIsNull = null;

        // Error: Can't specify indefinite target type.
        // var myLambda = (int n) -> n * n;

        // Can use a definite (explicit) target type.
        var op = getOperator();
        System.out.println(op.apply(42));

        // Can declare final var's.
        final var bestTeamInWales = "Swansea City";
        System.out.printf("Best team in Wales is and will always be %s\n", bestTeamInWales);
    }

    // Errors. Can't use var on non-locals.
    // var someInstanceVariable = 42;
    // static var someClassVariable = "Hello";

    // Errors. Can't use var on function params or return types.
    /*
    var someFunc(var p1, var p2) {
        return "it's a brexitastrophe";
    }
    */

    private static MyUnaryOperator getOperator() {
        return n -> n * n;
    }
}