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

    // 分配班级
    public void assignTo(Klass klass) {
        if (klass != null) {
            this.assignedClasses.add(klass);
        }
    }

    // 判断教师是否属于某个班级
    public boolean belongsTo(Klass klass) {
        return klass != null && this.assignedClasses.contains(klass);
    }

    // 返回教师的介绍
    @Override
    public String introduce() {
        if (!assignedClasses.isEmpty()) {
            // 使用Collectors.joining拼接班级号，避免toString()和replace()的繁琐操作
            String classNumbers = assignedClasses.stream()
                    .map(Klass::getNumber)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")); // 使用逗号连接班级号
            return this.introduceWords + " I teach Class " + classNumbers + ".";
        }
        return this.introduceWords;
    }

    // 判断教师是否正在授课某个学生
    public boolean isTeaching(Student student) {
        return student != null && this.assignedClasses.contains(student.getKlass());
    }
}
