package day8;

import java.util.Scanner;

public class PrimeNumberSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Prime numbers up to " + n + " are:");
        printPrimes(2, n);
    }

    public static void printPrimes(int current, int n) {
        if (current > n) {
            return;
        }
        if (isPrime(current, 2)) {
            System.out.print(current + " ");
        }
        printPrimes(current + 1, n);
    }

    public static boolean isPrime(int num, int divisor) {
        if (num < 2) {
            return false;
        }
        if (divisor > Math.sqrt(num)) {
            return true;
        }
        if (num % divisor == 0) {
            return false;
        }
        return isPrime(num, divisor + 1);
    }
}
