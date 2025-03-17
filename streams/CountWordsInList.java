package test.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordsInList {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apple", "cherry", "banana", "apple");
        words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);
    }
}
