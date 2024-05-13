package day3.result;

import java.util.Scanner;


    public class School {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();

            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            Student student = new Student(name, rollNumber, numSubjects);

            for (int i = 0; i < numSubjects; i++) {
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter subject " + (i + 1) + " name: ");
                String subjectName = scanner.nextLine();
                Subject subject = new Subject(subjectName);

                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                int marks = scanner.nextInt();
                subject.setMarks(marks);

                student.addSubject(i, subject);
            }

            System.out.println("\n--- Student Result ---");
            student.displayResult();

            scanner.close();
        }
    }