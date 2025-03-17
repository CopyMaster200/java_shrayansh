package test.streams;

import java.util.List;

public class CheckListHasOnlyEven {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10);
        System.out.println(numbers.stream().allMatch(x -> x % 2 == 0));
    }
}
