package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import oo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_return_true_when_equals_given_two_school_with_same_id() {
        School school1 = new School(1,"A",null, null);
        School school2 = new School(1,"B",null, null);

        assertThat(school1).isEqualTo(school2);
    }

    @Test
    public void should_no_teacher_and_no_student_introduce_when_null_school_startSchool_() {
        // Given
        School school = new School(1,"A",null, null);
        // When
        String result = school.startSchool();

        // Then
        String expectedOutput = "Our teachers:\n" +
                "empty\n" +
                "Our students:\n" +
                "empty";

        assertEquals(expectedOutput, result);
    }

    @Test
    public void should_has_teacher_and_no_student_introduce_when_null_school_startSchool_() {
        // Given
        Teacher jerry = new Teacher(1, "Jerry", 35);
        Klass klass1 = new Klass(1);
        jerry.assignTo(klass1);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(jerry);
        School school = new School(1,"A",teachers, null);
        // When
        String result = school.startSchool();

        // Then
        String expectedOutput = "Our teachers:\n" +
                "My name is Jerry. I am 35 years old. I am a teacher. I teach Class 1 in A School.\n" +
                "Our students:\n" +
                "empty";

        assertEquals(expectedOutput, result);
    }

    @Test
    public void should_no_teacher_and_has_student_introduce_when_null_school_startSchool_() {
        // Given
        Student tom = new Student(1, "Tom", 18);
        Klass klass1 = new Klass(1);
        tom.join(klass1);
        klass1.assignLeader(tom);

        Student zane = new Student(2, "Zane", 18);
        Klass klass2 = new Klass(2);
        tom.join(klass2);

        List<Student> students = new ArrayList<>();
        students.add(tom);
        students.add(zane);
        School school = new School(1,"A",null, students);
        // When
        String result = school.startSchool();

        // Then
        String expectedOutput = "Our teachers:\n" +
                "empty\n" +
                "Our students:\n" +
                "My name is Tom. I am 18 years old. I am a student. I am in class 2 in A School.\n" +
                "My name is Zane. I am 18 years old. I am a student in A School.";

        assertEquals(expectedOutput, result);
    }

    @Test
    public void should_all_teacher_and_student_introduce_when_startSchool_() {
        // Given
        Student tom = new Student(1, "Tom", 18);
        Klass klass1 = new Klass(1);
        tom.join(klass1);
        klass1.assignLeader(tom);

        Student zane = new Student(2, "Zane", 18);
        Klass klass2 = new Klass(2);
        tom.join(klass2);

        Teacher jerry = new Teacher(1, "Jerry", 35);
        jerry.assignTo(klass1);
        jerry.assignTo(klass2);
        List<Student> students = new ArrayList<>();
        students.add(tom);
        students.add(zane);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(jerry);
        School school = new School(1,"A",teachers, students);
        // When
        String result = school.startSchool();

        // Then
        String expectedOutput = "Our teachers:\n" +
                "My name is Jerry. I am 35 years old. I am a teacher. I teach Class 1, 2 in A School.\n" +
                "Our students:\n" +
                "My name is Tom. I am 18 years old. I am a student. I am in class 2 in A School.\n" +
                "My name is Zane. I am 18 years old. I am a student in A School.";

        assertEquals(expectedOutput, result);
    }

    private String systemOut() {
        return outContent.toString();
    }
}
