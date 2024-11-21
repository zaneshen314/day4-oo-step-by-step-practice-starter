package oo.observer;

import oo.observer.msg.Message;

public interface Publisher {

    void addListener(Subscriber subscriber);

    void removeListener(Subscriber subscriber);

    void notifyListeners(Message message);
}
