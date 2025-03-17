package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Java 8 Stream API",
                "Java 8 Functional Programming feature",
                "Optional feature");

        Set<String> set = sentences.stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toSet());

        System.out.println(set);
    }
}
