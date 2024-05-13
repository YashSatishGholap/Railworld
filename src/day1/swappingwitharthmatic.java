package day1;

import java.util.Scanner;

public class swappingwitharthmatic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of first variable: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of second variable: ");
        int b = scanner.nextInt();
        System.out.println("Before swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        // Swapping without using a third variable
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        scanner.close();
    }
}

