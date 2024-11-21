package oo.observer.publisher;

import oo.observer.subscriber.Subscriber;
import oo.observer.message.Message;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void addListener(Subscriber subscriber){
        subscribers.add(subscriber);
    };

    public void removeListener(Subscriber subscriber){
        subscribers.remove(subscriber);
    };

    public void notifyListeners(Message message){
        subscribers.forEach(subscriber -> subscriber.accept(message));
    };

}
