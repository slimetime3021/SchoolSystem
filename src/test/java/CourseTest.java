import org.derick.Assignment;
import org.derick.Course;
import org.derick.Department;
import org.derick.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {

    @Test
    @DisplayName("Valid weight")
    void testIsAssignmentWeightValid1() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Maths", 12, dept, new ArrayList<>());
        course.addAssignment("Assignment 1", 40.0);
        course.addAssignment("Assignment 2", 60.0);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid Weight")
    void testIsAssignmentWeightValid2() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Maths", 12, dept, new ArrayList<>());
        course.addAssignment("Assignment 1", 20.0);
        course.addAssignment("Assignment 2", 60.0);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Successful register")
    void testRegisterStudent1() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Maths", 12, dept, new ArrayList<>());

        Student student = new Student("Ethan Collins", Student.Gender.MALE, null, dept);

        boolean expected = true;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Duplicate register")
    void testRegisterStudent2() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Maths", 12, dept, new ArrayList<>());

        Student student = new Student("Ethan Collins", Student.Gender.MALE, null, dept);
        course.registerStudent(student);

        boolean expected = false;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Remove Student Successful")
    void testRemoveStudent1() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Maths", 12, dept, new ArrayList<>());

        Student student = new Student("Ethan Collins", Student.Gender.MALE, null, dept);
        course.registerStudent(student);

        boolean expected = true;
        boolean actual = course.removeStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Remove student not registered")
    void testRemoveStudent2() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Maths", 12, dept, new ArrayList<>());

        Student student = new Student("Ethan Collins", Student.Gender.MALE, null, dept);

        boolean expected = false;
        boolean actual = course.removeStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCalcStudentsAverage() {
        Department dept = new Department("Computer Science");
        Course course = new Course("Maths", 12, dept, new ArrayList<>());

        Student s1 = new Student("Ethan Collins", Student.Gender.MALE, null, dept);
        Student s2 = new Student("Lucas Bennett", Student.Gender.MALE, null, dept);
        s2.registerCourse(course);
        s1.registerCourse(course);

        Assignment a1 = new Assignment("Assignment 1", 50.0);
        a1.setScores(new ArrayList<>(List.of(80, 90)));

        Assignment a2 = new Assignment("Assignment 2", 50.0);
        a2.setScores(new ArrayList<>(List.of(70, 85)));

        course.getAssignments().add(a1);
        course.getAssignments().add(a2);

        int[] averages = course.calcStudentsAverage();

        int expected = (80*50 + 70*50) / 100;
        int actual = averages[0];

        Assertions.assertEquals(expected, actual);
    }
}
