package org.derick;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Student {
    @Getter private String studentId;
    @Getter @Setter private String studentName;
    @Getter @Setter private Gender gender;
    @Getter @Setter private Address address;
    @Getter @Setter private Department department;
    @Getter @Setter private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);
        course.registerStudent(this);
        return true;
    }

    enum Gender {
        MALE, FEMALE
    }
}
