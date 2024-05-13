package day4;

import java.util.Scanner;

public class CrossDiagonal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int n = sc.nextInt();

        int[][] nums = new int[m][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix with cross diagonal pattern:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    System.out.print(nums[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
