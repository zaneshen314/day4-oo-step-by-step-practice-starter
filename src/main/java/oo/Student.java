package oo;

public class Student extends Person {

    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public Student(int id, String name, int age) {
        super(id, name, age);
        this.introduceWords += " I am a student.";
    }

    public void join(Klass klass) {
        if (klass == null) return;
        this.klass = klass;
    }

    @Override
    public String introduce() {
        if (klass != null) {
            if (this.equals(klass.getClassLeader())) {
                return this.introduceWords + " I am the leader of class " + this.klass.getNumber() + ".";
            }
            return this.introduceWords + " I am in class " + this.klass.getNumber() + ".";
        }
        return this.introduceWords;
    }

    public boolean isIn(Klass klass) {
        if (klass == null) return false;
        return klass.equals(this.klass);
    }
}
