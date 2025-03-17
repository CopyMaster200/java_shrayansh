package interviews;

import java.util.Arrays;
import java.util.LinkedList;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0,   3, 12};
        moveZeroes(arr);
        System.out.println("Arrays (in-place): "+Arrays.toString(arr));
        moveZerosToLast(arr);
    }

    private static void moveZerosToLast(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int num : arr) {
            if (num == 0) {
                list.addLast(num);
            } else {
                list.add(num);
            }
        }
        System.out.println("LinkedList: " + list);
    }

    private static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0; // Pointer for the position of the next non-zero element

        // Pass 1: Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only when necessary to maintain in-place operation
                if (i != nonZeroIndex) {
                    int temp = nums[i];
                    nums[i] = nums[nonZeroIndex];
                    nums[nonZeroIndex] = temp;
                }
                nonZeroIndex++;
            }
        }
    }
}
