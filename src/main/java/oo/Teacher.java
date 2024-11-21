package oo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private Set<Klass> assignedClasses = new HashSet<>();
    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.introduceWords += " I am a teacher.";
    }

    public void assignTo(Klass klass) {
        if (klass == null) return;
        this.assignedClasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        if (klass == null) return false;
        return this.assignedClasses.contains(klass);
    }

    @Override
    public String introduce() {
        if (assignedClasses.size() != 0) {
            return this.introduceWords + " I teach Class " +
                    assignedClasses.stream().map(Klass::getNumber).collect(Collectors.toList()).toString()
                            .replace("]","").replace("[","") + ".";
        }
        return this.introduceWords;
    }

    public boolean isTeaching(Student student) {
        if (student == null) return false;
        return this.assignedClasses.contains(student.getKlass());
    }
}
