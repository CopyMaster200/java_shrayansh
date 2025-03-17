package test.streams;

import java.util.Comparator;
import java.util.List;

public class LongestWordInList {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "strawberry", "mango");
        int result = words.stream()
                .map(x -> x.length())
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        System.out.println("NON Optimized: "+words.stream().filter(x -> x.length() == result).findFirst().orElse(null));

        String temp = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        System.out.println("Optimized: "+temp);
    }
}
