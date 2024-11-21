package oo;

import oo.observer.msg.Message;
import oo.observer.msg.UpdateKlassLeaderMessage;

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
        if (klass != null) {
            assignedClasses.add(klass);
        }
    }

    public boolean belongsTo(Klass klass) {
        return assignedClasses.contains(klass);
    }

    @Override
    public String introduce() {
        if (assignedClasses.isEmpty()) {
            return introduceWords;
        }

        String classNumbers = assignedClasses.stream()
                .map(Klass::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return introduceWords + " I teach Class " + classNumbers + ".";
    }

    public boolean isTeaching(Student student) {
        return student != null && assignedClasses.contains(student.getKlass());
    }

    public void updateKlassLeader(Klass klass, Student leader) {
        if (leader != null) {
            System.out.printf("I am %s, teacher of Class %d. I know %s become Leader.%n", name, klass.getNumber(), leader.getName());
        }
    }

    @Override
    public void accept(Message message) {
        if (message instanceof UpdateKlassLeaderMessage updateKlassLeaderMessage){
            updateKlassLeader(updateKlassLeaderMessage.getKlass(),updateKlassLeaderMessage.getLeader());
        }
    }

}
