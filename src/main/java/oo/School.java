package oo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class School {
    private int id;
    private String name;
    private List<Teacher> teachers;
    private List<Student> students;

    public School() {
    }

    public School(int id, String name, List<Teacher> teachers, List<Student> students) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
    }

    private String generateInfo(List<? extends Person> people) {
        return (people == null || people.isEmpty()) ?
                "empty" :
                people.stream()
                        .map(person -> {
                            String original = person.introduce();
                            return (original.endsWith(".") ? original.substring(0, original.length() - 1) : original) +
                                    " in " + name + " School.";
                        })
                        .collect(Collectors.joining("\n"));
    }

    public String startSchool() {

        String teachersInfo = generateInfo(teachers);
        String studentsInfo = generateInfo(students);

        return "Our teachers:\n" + teachersInfo + "\nOur students:\n" + studentsInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return id == school.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
