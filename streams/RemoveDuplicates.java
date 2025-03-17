package test.streams;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 8, 15, 10, 5, 30, 20);
        System.out.println(numbers);
        System.out.println(numbers.stream()
                .distinct()
                .collect(Collectors.toList()));
    }
}
