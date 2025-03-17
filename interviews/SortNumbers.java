package interviews;

import java.util.Arrays;

public class SortNumbers {
    public static void main(String[] args) {
        Number[] nums = {1, 5, 2, 1.0, 5.0, 2.0};
        Arrays.stream(nums)
                .filter(num -> num instanceof Double)
                .sorted()
                .forEach(System.out::println);
    }
}
