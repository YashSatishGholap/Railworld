package day3.result;

import java.util.Scanner;

class Subject {
    private String name;
    private int marks;

    public Subject(String name) {
        this.name = name;
        this.marks = 0; // Initialize marks to 0
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
