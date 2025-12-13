package org.derick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@EqualsAndHashCode
public class Assignment {
    @Getter private String assignmentId;
    @Getter private String assignmentName;
    @Getter @Setter private double weight;
    @Getter @Setter private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentName = Util.toTitleCase(assignmentName);
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.assignmentId = String.format("%06d", nextId++);
    }

    public double calculateAssignmentAvg() {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Integer num : scores) {
            sum += num;
        }

        return sum / scores.size();
    }

    public void generateRandomScore() {
        Random rand = new Random();
        int num = rand.nextInt(0,11);

        Integer score = switch (num){
            case 0 -> rand.nextInt(0,60);
            case 1, 2 -> rand.nextInt(60,70);
            case 3, 4 -> rand.nextInt(70,80);
            case 5, 6, 7, 8 -> rand.nextInt(80,90);
            case 9, 10 -> rand.nextInt(90,100);
            default -> -1;
        };

        scores.add(score);
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = Util.toTitleCase(assignmentName);
    }

    @Override
    public String toString() {
        return String.format("Assignment Id: %s, Name: %s, Weight: %.2f", assignmentId, assignmentName, weight);
    }
}
