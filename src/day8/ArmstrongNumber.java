package day8;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (isArmstrong(num, num, 0)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
    }

    public static boolean isArmstrong(int original, int num, int sum) {
        if (num == 0) {
            return sum == original;
        }
        int digit = num % 10;
        sum += Math.pow(digit, 3);
        return isArmstrong(original, num / 10, sum);
    }
}

