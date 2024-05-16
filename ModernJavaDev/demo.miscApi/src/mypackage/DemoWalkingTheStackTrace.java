package mypackage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoWalkingTheStackTrace {

    public static void doDemo() {

        System.out.println("\nIn DemoProcessAPI");

        // Let's set up a chain of method calls, to create an interesting stack trace to walk.
        method1();
    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        method3();
    }

    private static void method3() {

        // Get a thread-safe StackWalker object.
        StackWalker sw = StackWalker.getInstance();

        // Call the StackWalker's walk() method, to walk the stack. 
        // walk() builds a Stream of StackFrames. 
        // You must give walk() a Function<Stream<StackFrame>, T> telling it what to do to the Stream.
	    List<StackWalker.StackFrame> allStackFrames = sw.walk(stackFrameStream -> getAllFrames(stackFrameStream));
        System.out.println("\nFull stack trace:");
        allStackFrames.forEach(System.out::println);

        // Now let's do it again, but ignoring StackFrames that refer to the Main class.
	    List<StackWalker.StackFrame> someStackFrames = sw.walk(stackFrameStream -> getFramesExceptForClass(stackFrameStream, "mypackage.Main"));
        System.out.println("\nPartial stack trace, excluding any method calls on Main class:");
        someStackFrames.forEach(System.out::println);
    }

    private static List<StackWalker.StackFrame> getAllFrames(Stream<StackWalker.StackFrame> stackFrameStream) {
        return stackFrameStream.collect(Collectors.toList());
    }

    private static List<StackWalker.StackFrame> getFramesExceptForClass(Stream<StackWalker.StackFrame> stackFrameStream, String classname) {
        return stackFrameStream.filter(stackFrame -> !(stackFrame.getClassName().equals(classname)))
                               .collect(Collectors.toList());
    }
}