import java.util.Random;
import java.util.Scanner;

public class ArraySearchComperision {


    public static int searchIterative(int[] arr, int searchValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                return 1;
            }
        }
        return 0;
    }


    public static int searchRecursive(int[] arr, int searchValue, int index) {
        if (index >= arr.length) {
            return 0;
        }
        if (arr[index] == searchValue) {
            return 1;
        }
        return searchRecursive(arr, searchValue, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];


        System.out.println("Random values in array:");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Enter value to search: ");
        int f = sc.nextInt();


        long startTimeIterative = System.nanoTime();
        int resultIterative = searchIterative(arr, f);
        long endTimeIterative = System.nanoTime();
        long iterativeTime = endTimeIterative - startTimeIterative;


        long startTimeRecursive = System.nanoTime();
        int resultRecursive = searchRecursive(arr, f, 0);
        long endTimeRecursive = System.nanoTime();
        long recursiveTime = endTimeRecursive - startTimeRecursive;


        System.out.println("Iterative approach result: " + resultIterative);
        System.out.println("Recursive approach result: " + resultRecursive);

        System.out.println("Time taken by Iterative approach: " + iterativeTime + " nanoseconds");
        System.out.println("Time taken by Recursive approach: " + recursiveTime + " nanoseconds");

        if (iterativeTime < recursiveTime) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }

    }
}
