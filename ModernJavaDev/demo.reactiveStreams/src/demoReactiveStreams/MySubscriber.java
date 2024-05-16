package demoReactiveStreams;

import java.util.concurrent.Flow;
import java.util.ArrayList;

public class MySubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;
    public ArrayList<T> consumedItems = new ArrayList<>();
 
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("MySubscriber onSubscribe()");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println("MySubscriber onNext(): " + item);
        consumedItems.add(item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("MySubscriber onError(): " + t);
        t.printStackTrace();
    }
 
    @Override
    public void onComplete() {
        System.out.println("MySubscriber onComplete()");
    }
}