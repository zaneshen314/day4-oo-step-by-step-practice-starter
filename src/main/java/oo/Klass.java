package oo;

import oo.observer.publisher.KlassPublisher;
import oo.observer.message.UpdateKlassLeaderMessage;
import oo.observer.subscriber.Subscriber;

import java.util.Objects;

public class Klass {
    private final int number;
    private Student classLeader;
    private final KlassPublisher klassPublisher = new KlassPublisher();

    public int getNumber() {
        return number;
    }
    public Student getClassLeader() {
        return classLeader;
    }

    public void attach(Subscriber subscriber) {
        klassPublisher.addListener(subscriber);
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
        klassPublisher.notifyListeners(new UpdateKlassLeaderMessage(this,leader));
    }

    public boolean isLeader(Student leader) {
        return leader.equals(this.classLeader);
    }

}
