package oo;

public class Student extends Person {

    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public Student(int id, String name, int age) {
        super(id, name, age);
        this.introduceWords.append(" I am a student.");
    }

    public void join(Klass klass) {
        if (klass == null) return;
        this.klass = klass;
        this.introduceWords.append(" I am in class ")
                .append(this.klass.getNumber())
                .append(".");
    }

    public boolean isIn(Klass klass) {
        if (klass == null) return false;
        return klass.equals(this.klass);
    }
}
