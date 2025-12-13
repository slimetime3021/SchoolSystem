package org.derick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
public class Course {
    @Getter private String courseId;
    @Getter @Setter private String courseName;
    @Getter @Setter private double credits;
    @Getter @Setter private Department department;
    @Getter @Setter private ArrayList<Assignment> assignments;
    @Getter @Setter private ArrayList<Student> registeredStudents;
    private static int nextId = 1;

    boolean isAssignmentWeightValid(){
        double sum = 0;
        for (Assignment assignment : assignments){
            sum += assignment.getWeight();
        }
        return sum == 100.0;
    }

    boolean registerStudent(Student student){
        if (registeredStudents.contains(student)){
            return false;
        }
        registeredStudents.add(student);
        for (Assignment assignment : assignments){
            assignment.generateRandomScore();
        }
        return true;
    }
}
