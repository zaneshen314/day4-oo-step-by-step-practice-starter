package oo;

import java.util.Objects;

public class Klass {
    private int number;
    private Student classLeader;

    public int getNumber() {
        return number;
    }
    public Student getClassLeader() {
        return classLeader;
    }

    public void setNumber(int number) {
        this.number = number;
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
    }

    public boolean isLeader(Student leader) {
        return leader.equals(this.classLeader);
    }
}
