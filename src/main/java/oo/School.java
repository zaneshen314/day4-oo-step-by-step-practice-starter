package oo;

import java.util.HashSet;
import java.util.Set;

public class School {
    private String name;
    private Set<Klass> classes;
    private Set<Teacher> teachers;

    public School(String name) {
        this.name = name;
        this.classes = new HashSet<>();
        this.teachers = new HashSet<>();
    }

    // 添加班级
    public void addKlass(Klass klass) {
        classes.add(klass);
    }

    // 添加教师
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.introduceWords = teacher.introduceWords.replace("I am a teacher.", "I am a teacher in Greenwood School.");

    }

    // 获取班级
    public Klass getKlass(int number) {
        for (Klass klass : classes) {
            if (klass.getNumber() == number) {
                return klass;
            }
        }
        return null;
    }

    // 获取所有班级
    public Set<Klass> getClasses() {
        return classes;
    }

    // 获取所有教师
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    // 学校的名称
    public String getName() {
        return name;
    }
}
