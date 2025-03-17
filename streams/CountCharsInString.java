package test.streams;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharsInString {
    public static void main(String[] args) {
        String input = "banana"; //"hello world";
        input.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }
}
