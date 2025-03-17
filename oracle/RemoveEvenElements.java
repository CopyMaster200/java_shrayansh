package test.oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveEvenElements {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        usingArrayListMethods(input);
        usingIteratorMethods(input);
    }

    private static void usingIteratorMethods(List<Integer> input) {
        System.out.println("usingIteratorMethods");
        List<Integer> nums = new ArrayList<>(input);
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }
        System.out.println(nums);
    }

    private static void usingArrayListMethods(List<Integer> input) {
        System.out.println("usingArrayListMethods");
        List<Integer> nums = new ArrayList<>(input);
        System.out.println(nums);
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            if (nums.get(i) % 2 == 0) {
                nums.remove(nums.get(i));
                size = nums.size();
            }
        }
        System.out.println(nums);
    }
}
