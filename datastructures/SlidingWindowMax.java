package test.datastructures;

import java.util.*;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements (they are useless)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add new element at rear
            deque.offerLast(i);

            // Store maximum for the first valid window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        maxWindow(nums,k);
        // Output: [3, 3, 5, 5, 6, 7]
    }

    private static void maxWindow(int[] nums, int k) {
        TreeSet<Integer> maxWin = new TreeSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            int index=i;
            maxWin.clear();
            while(index<i+k) {
                maxWin.add(nums[index++]);
            }
            result.add(maxWin.pollLast());
        }
        System.out.println(result);
    }
}
