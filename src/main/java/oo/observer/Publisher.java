package oo.observer;

import oo.observer.msg.Message;

import java.util.ArrayList;
import java.util.List;

public interface Publisher {
    List<Subscriber> subscribers = new ArrayList<>();

    default void addListener(Subscriber subscriber){
        subscribers.add(subscriber);
    };

    default void removeListener(Subscriber subscriber){
        subscribers.remove(subscriber);
    };

    default void notifyListeners(Message message){
        subscribers.forEach(subscriber -> subscriber.accept(message));
    };

}
