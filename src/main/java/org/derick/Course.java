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

    public Course(String courseName, double credits, Department department,
                  ArrayList<Assignment> assignments, ArrayList<Student> registeredStudents) {

        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
    }

    public boolean isAssignmentWeightValid(){
        double sum = 0;
        for (Assignment assignment : assignments){
            sum += assignment.getWeight();
        }
        return sum == 100.0;
    }

    public boolean registerStudent(Student student){
        if (registeredStudents.contains(student)){
            return false;
        }
        registeredStudents.add(student);
        return true;
    }

    public void removeStudent(Student student){
        int index = registeredStudents.indexOf(student);

        if (index < 0) {
            return;
        }

        for (Assignment assignment : assignments){
            if (index >= assignment.getScores().size()){
                continue;
            }
            assignment.getScores().remove(index);
        }
        registeredStudents.remove(student);
    }

    public int[] calcStudentsAverage() {
        int[] finalScores = new int[registeredStudents.size()];
        for (int i = 0; i<registeredStudents.size(); i++){
            for (Assignment assignment : assignments){
                finalScores[i] += (int) Math.round(assignment.getScores().get(i)*assignment.getWeight());
            }
            finalScores[i] /= 100;
        }
        return finalScores;
    }

    public void generateScores(){
        for (int i = 0; i<registeredStudents.size(); i++){
            for (Assignment assignment : assignments){
                assignment.generateRandomScore();
            }
        }
    }

    public void displayScores() {
        StringBuilder sb = new StringBuilder();

        sb.append("Course: ")
                .append(courseName)
                .append(" (")
                .append(courseId)
                .append(")\n");

        // Header
        sb.append(String.format("%-25s", ""));
        for (Assignment assignment : assignments) {
            sb.append(String.format("%-15s", assignment.getAssignmentName()));
        }
        sb.append(String.format("%-15s%n", "Final Score"));

        // Student
        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);

            sb.append(String.format("%-25s", student.getStudentName()));

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                sb.append(String.format("%-15s", score == null ? "N/A" : score));
            }

            sb.append(String.format("%-15d%n", finalScores[i]));
        }

        // Average
        sb.append(String.format("%-25s", "Average"));
        for (Assignment assignment : assignments) {
            sb.append(
                    String.format(
                            "%-15d",
                            (int) Math.round(assignment.calculateAssignmentAvg())
                    )
            );
        }

        System.out.println(sb);
    }

    public String toSimplifiedString() {
        return String.format(
                "%s | %s | %.2f credits | %s",
                courseId,
                courseName,
                credits,
                department != null ? department.getDepartmentName() : "N/A"
        );
    }
}
