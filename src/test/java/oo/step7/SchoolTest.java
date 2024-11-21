package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_message_when_teacher_is_assigned_to_school() {
        // Given
        School school = new School("Greenwood School");
        Teacher jerry = new Teacher(1, "Jerry", 21);

        // When
        school.addTeacher(jerry);
        String introduce = jerry.introduce();

        // Then
        assertThat(introduce).contains("My name is Jerry. I am 21 years old. I am a teacher in Greenwood School.");
    }

    private String systemOut() {
        return outContent.toString();
    }
}
