package test.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentNumber {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 5, 6, 4, 7, 5, 4, 8, 5, 5, 6, 7, 4);
        Map.Entry<Integer, Long> result = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElse(null);
        System.out.println(result.getValue());
    }
}
