import java.util.Scanner;

public class SimpleRecursion {

    public static void Ascending(int n) {
        if (n == 0) {
            return;
        }
        Ascending(n - 1);
        System.out.print(n + " ");
    }


    public static void Descending(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        Descending(n - 1);
       // System.out.println(n+" ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number N: ");
        int N = scanner.nextInt();

        System.out.println("Numbers in ascending order:");
        Ascending(N);

        System.out.println("\nNumbers in descending order:");
        Descending(N);

       // scanner.close();
    }
}



