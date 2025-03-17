package datastructures;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> maxSet = new TreeSet<>();
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        for (int i = 0; i < nums.length - k; i++) {
            maxSet.addAll(IntStream.of(Arrays.copyOfRange(nums, i, k+i)).boxed().toList());
            System.out.println(maxSet);
            result[count] = maxSet.last();
            count++;
            maxSet.clear();
        }

        return result;
    }
}
