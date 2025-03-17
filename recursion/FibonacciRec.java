package test.recursion;

import java.util.Scanner;

/**
 * Find the nth fibonacci number
 * Fibonacci Number is the sum of previous twp numbers.
 * Example sequence: 0 1 1 2 3 5 8 . . .
 */
public class FibonacciRec {
    public static void main(String[] args) {
        System.out.println("Enter a number to find nth Fibo:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(fib(n));
    }

    private static int fib(int n) {
        // Base case where n = 0 or 1
        if (n < 2)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

}
