package day3.result;

// Student class
class Student {
    private String name;
    private int rollNumber;
    private Subject[] subjects;

    public Student(String name, int rollNumber, int numSubjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = new Subject[numSubjects];
    }

    public void addSubject(int index, Subject subject) {
        subjects[index] = subject;
    }

    public void displayResult() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Subjects:");

        for (Subject subject : subjects) {
            System.out.println(subject.getName() + ": " + subject.getMarks());
        }
    }
}
