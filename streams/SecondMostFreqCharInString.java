package test.streams;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMostFreqCharInString {
    public static void main(String[] args) {
        String input = "banana";
        Map.Entry<Character, Long> temp = input.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second most frequent char in String: " + temp);
    }
}
