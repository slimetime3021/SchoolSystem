package org.derick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@EqualsAndHashCode
public class Student {
    @Getter private String studentId;
    @Getter @Setter private String studentName;
    @Getter @Setter private Gender gender;
    @Getter @Setter private Address address;
    @Getter @Setter private Department department;
    @Getter @Setter private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new  ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.registerStudent(this);
        return true;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent(this);
        } else {
            return false;
        }
        return true;
    }

    public String toSimplifiedString() {
        return String.format(
                "Id: %s | Name: %s | Department: %s",
                studentId,
                studentName,
                department != null ? department.getDepartmentName() : "N/A"
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(studentId).append("\n");
        sb.append("Student Name: ").append(studentName).append("\n");
        sb.append("Registered Courses:\n");

        if (registeredCourses == null || registeredCourses.isEmpty()) {
            sb.append("  None\n");
        } else {
            for (Course course : registeredCourses) {
                sb.append("  ")
                        .append(course.getCourseId())
                        .append(" | ")
                        .append(course.getCourseName())
                        .append(" | ")
                        .append(
                                course.getDepartment() != null
                                        ? course.getDepartment().getDepartmentName()
                                        : "N/A"
                        )
                        .append("\n");
            }
        }

        return sb.toString();
    }

    public enum Gender {
        MALE, FEMALE
    }
}
