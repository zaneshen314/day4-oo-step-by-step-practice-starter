package oo.observer.subscriber;

import oo.observer.message.Message;

public interface Subscriber {

    void accept(Message message);
}
