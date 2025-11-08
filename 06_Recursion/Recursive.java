import java.util.Scanner;

public class Recursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fibonacci
        System.out.println("Calculating Fibonacci number.");
        System.out.print("Enter the Fibonacci sequence index (non-negative integer): ");
        int fibIndex = scanner.nextInt();
        System.out.println("The Fibonacci number is: " + fibonacci(fibIndex));

        // GCD
        System.out.println("\nCalculating GCD of two numbers.");
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();

        // ✅ Simply call the recursive function
        System.out.println("The GCD is: " + gcd(a, b));

        // Max value in array
        System.out.println("\nFinding max value in array: {5,6,2,5,1,3,34,98,1,2,65}");
        int[] arr = {5, 6, 2, 5, 1, 3, 34, 98, 1, 2, 65};
        System.out.println("The max value is: " + maxVal(arr, 0, 0));
    }

    // Recursive Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ✅ Simplest Recursive GCD
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Recursive Max Value
    public static int maxVal(int[] arr, int m, int i) {
        if (i == arr.length)
            return m;
        int max = (arr[i] > m) ? arr[i] : m;
        return maxVal(arr, max, i + 1);
    }
}
