package org.derick;

import java.util.ArrayList;
import java.util.Random;

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

    void generateRandomScore() {
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
}
