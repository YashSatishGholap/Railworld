package day3.ElectricityBill;
import java.util.Scanner;
public class customer {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the number of units consumed:");
            int unitsConsumed = scanner.nextInt();

            double billAmount = calculateBill(unitsConsumed);

            System.out.println("Electricity Bill: $" + billAmount);

            scanner.close();
        }

        public static double calculateBill(int unitsConsumed) {
            double billAmount = 0;

            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2;
            } else if (unitsConsumed <= 150) {
                billAmount = 100 + (unitsConsumed - 100) * 3;
            } else if (unitsConsumed <= 200) {
                billAmount = 200 + (unitsConsumed - 150) * 4;
            } else if (unitsConsumed <= 250) {
                billAmount = 400 + (unitsConsumed - 200) * 5;
            } else if (unitsConsumed <= 300) {
                billAmount = 650 + (unitsConsumed - 250) * 6;
            } else if (unitsConsumed <= 500) {
                billAmount = 1000 + (unitsConsumed - 300) * 7;
            } else {
                billAmount = 2200 + (unitsConsumed - 500) * 8;
            }

            return billAmount;
        }
    }

