package day3;
import java.util.Scanner;
public class oppositeofpeekelement {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input array size
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            int[] arr = new int[size];

            // Input array elements from user
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++) {
                System.out.print("Enter element at index " + i + ": ");
                arr[i] = scanner.nextInt();
            }

            // Find the peak element (assuming it's the largest)
            int peakIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[peakIndex]) {
                    peakIndex = i;
                }
            }

            // Find the opposite element
            int oppositeIndex;
            if (peakIndex == 0) {
                oppositeIndex = 1;
            } else if (peakIndex == size - 1) {
                oppositeIndex = size - 2;
            } else {
                int leftAdjacent = Math.abs(arr[peakIndex - 1] - arr[peakIndex]);
                int rightAdjacent = Math.abs(arr[peakIndex + 1] - arr[peakIndex]);

                if (leftAdjacent > rightAdjacent) {
                    oppositeIndex = peakIndex - 1;
                } else {
                    oppositeIndex = peakIndex + 1;
                }
            }

            // Print the opposite element
            System.out.println("The element opposite to the peak element " + arr[peakIndex] + " is: " + arr[oppositeIndex]);

            scanner.close();
        }
    }
