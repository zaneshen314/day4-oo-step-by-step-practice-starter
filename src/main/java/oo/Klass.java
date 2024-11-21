package oo;

import oo.observer.msg.Message;
import oo.observer.msg.UpdateKlassLeaderMessage;
import oo.observer.Publisher;
import oo.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass implements Publisher {
    private final int number;
    private Student classLeader;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public int getNumber() {
        return number;
    }
    public Student getClassLeader() {
        return classLeader;
    }

    public void attach(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public Klass(int number) {
        this.number = number;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void assignLeader(Student leader) {
        if (leader == null || !this.equals(leader.getKlass())) {
            System.out.println("It is not one of us.");
            return;
        }
        this.classLeader = leader;
        notifyListeners(new UpdateKlassLeaderMessage(this,leader));
    }

    public boolean isLeader(Student leader) {
        return leader.equals(this.classLeader);
    }

    @Override
    public void addListener(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeListener(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyListeners(Message message) {
        subscribers.forEach(subscriber -> subscriber.accept(message));
    }

}
