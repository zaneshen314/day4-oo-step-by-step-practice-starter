package oo;

import oo.observer.KlassObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int number;
    private Student classLeader;
    private List<KlassObserver> observers = new ArrayList<>();

    public int getNumber() {
        return number;
    }
    public Student getClassLeader() {
        return classLeader;
    }

    public void attach(KlassObserver observer) {
        observers.add(observer);
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
        notifyObservers();
    }

    private void notifyObservers() {
        for (KlassObserver observer : observers) {
            observer.updateKlassLeader(this, classLeader);
        }
    }

    public boolean isLeader(Student leader) {
        return leader.equals(this.classLeader);
    }
}
