package test.streams;

import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 8, 15, 25, 30);
        List<Integer> even = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Filter Even Numbers: " + even);
    }
}
