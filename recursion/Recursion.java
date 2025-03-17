package test.recursion;

public class Recursion {
    static int count = 1;

    public static void main(String[] args) {
        funnyRec(1);
    }

    /***
     * Recursion
     */
    private static void funnyRec(int count) {
        if (count == 4) {
            // base case: when to end the recursion.
            return;
        }
        System.out.println("hello: " + count);
        funnyRec(count+1);
    }
}
