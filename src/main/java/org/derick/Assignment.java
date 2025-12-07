package org.derick;

import java.util.ArrayList;

public class Assignment {
    String assignmentId;
    String assignmentName;
    double weight;
    ArrayList<Integer> scores;
    static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.assignmentId = String.format("%06d", nextId++);
    }
}
