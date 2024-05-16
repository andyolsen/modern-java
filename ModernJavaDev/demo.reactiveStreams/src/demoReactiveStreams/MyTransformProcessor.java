package demoReactiveStreams;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

// This Processor class is both a subscriber and a publisher.
// It subscribes to an upstream publisher, and publishes to a downstream publisher.
public class MyTransformProcessor<T,R>
    extends SubmissionPublisher<R> 
    implements Flow.Processor<T,R> {

    // This subscription manages our relationship with the upstream publisher.
    private Flow.Subscription subscription;

    // We'll perform this function on each received item, and publish the result.
    private Function<T,R> function;
 
    public MyTransformProcessor(Function<T,R> function) {
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("MyTransformProcessor onSubscribe()");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println("MyTransformProcessor onNext()");
        R transformResult = function.apply(item);
        this.submit(transformResult);

        // Hold your horses. Give the downstream subscriber a chance to intervene.
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException ex) {}
 
        // Tell the upstream publisher we're ready for some more action.    
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }
 
    @Override
    public void onComplete() {
        System.out.println("MyTransformProcessor onComplete()");
    }
}