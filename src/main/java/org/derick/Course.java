package org.derick;

import java.util.ArrayList;

public class Course {
    String courseId;
    String courseName;
    double credits;
    Department department;
    ArrayList<Assignment> assignments;
    ArrayList<Student> registeredStudents;
    static int nextId = 1;
}
