package day8;

import java.util.Scanner;

public class DisariumNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int length = Integer.toString(num).length();
        if (isDisarium(num, length, num)) {
            System.out.println(num + " is a Disarium number.");
        } else {
            System.out.println(num + " is not a Disarium number.");
        }
    }

    public static boolean isDisarium(int num, int length, int original) {
        if (num == 0) {
            return original == 0;
        }
        int digit = num % 10;
        original -= Math.pow(digit, length);
        return isDisarium(num / 10, length - 1, original);
    }
}
