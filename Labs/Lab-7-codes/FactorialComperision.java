import java.util.Scanner;

public class FactorialComperision {

    // Iterative approach to calculate factorial
    public static long factorialIterative(int N) {
        long result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive approach to calculate factorial
    public static long factorialRecursive(int N) {
        if (N == 0 || N == 1) {
            return 1; // Base case: factorial of 0 or 1 is 1
        }
        return N * factorialRecursive(N - 1); // Recursive case
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number N: ");
        int N = scanner.nextInt();

        // Measure time for iterative approach
        long startTimeIterative = System.nanoTime();
        long iterativeResult = factorialIterative(N);
        long endTimeIterative = System.nanoTime();
        long iterativeTime = endTimeIterative - startTimeIterative;

        // Measure time for recursive approach
        long startTimeRecursive = System.nanoTime();
        long recursiveResult = factorialRecursive(N);
        long endTimeRecursive = System.nanoTime();
        long recursiveTime = endTimeRecursive - startTimeRecursive;

        // Output the results
        System.out.println("\nFactorial using Iterative approach: " + iterativeResult);
        System.out.println("Factorial using Recursive approach: " + recursiveResult);

        // Output the time comparison
        System.out.println("\nTime taken by Iterative approach: " + iterativeTime + " nanoseconds");
        System.out.println("Time taken by Recursive approach: " + recursiveTime + " nanoseconds");

        // Compare which approach is faster
        if (iterativeTime < recursiveTime) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }

       // scanner.close();
    }
}

