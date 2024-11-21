package oo;

import java.util.Objects;

public class Student extends Person {

    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
        this.introduceWords += " I am a student.";
    }

    public Klass getKlass() {
        return klass;
    }

    public void join(Klass klass) {
        if (klass != null) {
            this.klass = klass;
        }
    }

    @Override
    public String introduce() {
        String introduction = super.introduceWords;

        if (klass != null) {
            if (this.equals(klass.getClassLeader())) {
                introduction += " I am the leader of class " + klass.getNumber() + ".";
            } else {
                introduction += " I am in class " + klass.getNumber() + ".";
            }
        }

        return introduction;
    }

    public boolean isIn(Klass klass) {
        return Objects.equals(this.klass, klass);
    }
}
