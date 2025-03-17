package bitwise;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 3, 2, 8, 5};
        System.out.println("Unique Number: " + findUnique(arr)); // Output: 8
    }

    public static int findUnique(int[] arr) {
        int unique = 0;
        for (int i : arr) {
            unique ^= i;
        }
        return unique;
    }
}
