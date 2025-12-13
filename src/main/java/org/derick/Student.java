package org.derick;

import java.util.ArrayList;

public class Student {
    String studentId;
    String studentName;
    Gender gender;
    Address address;
    Department department;
    ArrayList<Course> registeredCourses;
    static int nextId = 1;



    enum Gender {
        MALE, FEMALE
    }
}
