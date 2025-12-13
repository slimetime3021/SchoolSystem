import org.derick.Course;
import org.derick.Department;
import org.derick.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    @Test
    @DisplayName("register normally")
    void testRegisterCourse1() {
        Department dept = new Department("Computer Science");

        Course course = new Course("Math", 12, dept, new ArrayList<>());

        Student student = new Student("Ethan Collins", Student.Gender.MALE, null, dept);

        boolean expected = true;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void testRegisterCourseDuplicate() {
        Department dept = new Department("Computer Science");

        Course course = new Course("Math", 12, dept, new ArrayList<>());


        Student student = new Student("Ethan Collins", Student.Gender.MALE, null, dept);
        student.registerCourse(course);

        boolean expected = false;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testDropCourseSuccess() {
        Department dept = new Department("Computer Science");

        Course course = new Course("Math", 12, dept, new ArrayList<>());


        Student student = new Student("Ava Harrington", Student.Gender.FEMALE, null, dept);
        student.registerCourse(course);

        boolean expected = true;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testDropCourseNotRegistered() {
        Department dept = new Department("Computer Science");

        Course course = new Course("Math", 12, dept, new ArrayList<>());


        Student student = new Student("Lucas Bennett", Student.Gender.MALE, null, dept);

        boolean expected = false;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }
}
