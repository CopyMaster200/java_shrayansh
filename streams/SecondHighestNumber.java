package test.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 8, 15, 25, 30);
        Optional<Integer> temp = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst();

        System.out.println("Second Highest number: " + temp.get());
    }
}
