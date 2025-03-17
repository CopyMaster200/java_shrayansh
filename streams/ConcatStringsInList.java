package test.streams;

import java.util.List;
import java.util.stream.Collectors;

public class ConcatStringsInList {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Streams", "are", "powerful");
        String result = words.stream()
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
