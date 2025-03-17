package test.recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1};
        bubble(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] bubble(int[] arr, int start, int end) {
        if (start == 0 && end == 0)
            return arr;

        if (start == end) {
            return bubble(arr, 0, end - 1);
        }

        if (arr[start] > arr[start + 1]) {
            swap(arr, start);
            return bubble(arr, start + 1, end);
        }
        return bubble(arr, start + 1, end);
    }

    private static void swap(int[] arr, int start) {
        int temp = arr[start];
        arr[start] = arr[start + 1];
        arr[start + 1] = temp;
    }
}
