package oo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private final Set<Klass> assignedClasses = new HashSet<>();
    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.introduceWords.append(" I am a teacher.");
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
        if (assignedClasses.isEmpty()) return super.introduce();
        return this.introduceWords.append(" I teach Class ")
                .append(assignedClasses.stream().map(Klass::getNumber).
                        toList().toString()
                        .replace("]","")
                        .replace("[",""))
                .append(".").toString();
    }

    public boolean isTeaching(Student student) {
        if (student == null) return false;
        return this.assignedClasses.contains(student.getKlass());
    }
}
