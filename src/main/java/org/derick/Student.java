package org.derick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
                "%s | %s | %s",
                studentId,
                studentName,
                department != null ? department.getDepartmentName() : "N/A"
        );
    }

    public enum Gender {
        MALE, FEMALE
    }
}
