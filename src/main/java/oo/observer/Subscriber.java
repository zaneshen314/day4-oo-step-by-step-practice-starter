package oo.observer;

import oo.observer.msg.Message;

public interface Subscriber {

    void accept(Message message);
}
