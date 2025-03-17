package recursion;

import java.util.Scanner;

public class RecursionBackTracking {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();

        funnyRecBackTrack(range, range);
    }

    private static void funnyRecBackTrack(int i, int range) {
        if (i < 1) {
            return;
        } else {
            funnyRecBackTrack(i - 1, range);
            System.out.println(range-i+1);
        }
    }
}
