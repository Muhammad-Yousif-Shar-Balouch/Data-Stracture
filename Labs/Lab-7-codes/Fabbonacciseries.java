import java.util.Scanner;

public class Fabbonacciseries {


    public static void fibonacciIterative(int N) {
        int a = 0, b = 1, next;

        System.out.print("Iterative Fibonacci: ");
        for (int i = 1; i <= N; i++) {
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }


    public static int fibonacciRecursive(int N) {
        if (N <= 1) {
            return N;
        }
        return fibonacciRecursive(N - 1) + fibonacciRecursive(N - 2);
    }


    public static void printFibonacciRecursive(int N) {
        System.out.print("Recursive Fibonacci: ");
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();


        long startTimeIterative = System.nanoTime();
        fibonacciIterative(N);
        long endTimeIterative = System.nanoTime();
        long iterativeTime = endTimeIterative - startTimeIterative;

        long startTimeRecursive = System.nanoTime();
        printFibonacciRecursive(N);
        long endTimeRecursive = System.nanoTime();
        long recursiveTime = endTimeRecursive - startTimeRecursive;

        System.out.println("\nTime taken by Iterative approach: " + iterativeTime + " nanoseconds");
        System.out.println("Time taken by Recursive approach: " + recursiveTime + " nanoseconds");


        if (iterativeTime < recursiveTime) {
            System.out.println("Iterative approach is faster.");
        } else {
            System.out.println("Recursive approach is faster.");
        }

       // scanner.close();
    }
}

