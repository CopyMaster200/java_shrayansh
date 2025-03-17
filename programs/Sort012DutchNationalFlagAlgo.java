package test.programs;

import java.util.Arrays;

/**
 * Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 * You need to solve this problem without utilizing the built-in sort function.
 *
 * Examples:
 * Input: arr[] = [0, 1, 2, 0, 1, 2]
 * Output: [0, 0, 1, 1, 2, 2]
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 *
 * Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
 * Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class Sort012DutchNationalFlagAlgo {
    public static void main(String[] args) {
        Sort012DutchNationalFlagAlgo solution = new Sort012DutchNationalFlagAlgo();

        int[] arr1 = {0, 1, 2, 0, 1, 2};
        solution.sort012(arr1);
        System.out.println(Arrays.toString(arr1)); // Output: [0, 0, 1, 1, 2, 2]

        int[] arr2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        solution.sort012(arr2);
        System.out.println(Arrays.toString(arr2)); // Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]

        int[] arr3 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        solution.countAndPrint(arr3);
        System.out.println(Arrays.toString(arr3)); // Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
    }

    /**
     * Approach: Dutch National Flag Algorithm
     * We use three pointers:
     * low → Tracks the position for 0s
     * mid → Traverses the array
     * high → Tracks the position for 2s
     * We swap elements to move 0s to the left and 2s to the right, keeping 1s in the middle.
     *
     */
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Counting Sort Approach (Two-Pass, O(n) Time, O(1) Space)
     * Steps:
     * Count the number of 0s, 1s, and 2s.
     * Overwrite the original array with these counts
     */
    private void countAndPrint(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int num: arr) {
            if(num == 0) count0++;
            else if(num == 1) count1++;
            else if(num == 2) count2++;
        }

        int index = 0;
        while (count0-- > 0) arr[index++] = 0;
        while (count1-- > 0) arr[index++] = 1;
        while (count2-- > 0) arr[index++] = 2;
    }
}
