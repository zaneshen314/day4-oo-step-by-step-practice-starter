package oo;

import java.util.Objects;

public class Klass {
    private int number;
    private Student classLeader;
    private Student attachedStudent;
    private Teacher attachedTeacher;

    public int getNumber() {
        return number;
    }
    public Student getClassLeader() {
        return classLeader;
    }

    public void attach(Teacher teacher) {
        if (teacher != null && teacher.belongsTo(this)) attachedTeacher = teacher;
    }

    public void attach(Student student) {
        if (student != null && student.isIn(this)) attachedStudent = student;
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
        if (attachedStudent != null) System.out.format("I am %s, student of Class %d. I know %s become Leader.", attachedStudent.getName(), this.number, this.classLeader.getName());
        if (attachedTeacher != null) System.out.format("I am %s, teacher of Class %d. I know %s become Leader.", attachedTeacher.getName(), this.number, this.classLeader.getName());
    }

    public boolean isLeader(Student leader) {
        return leader.equals(this.classLeader);
    }
}
