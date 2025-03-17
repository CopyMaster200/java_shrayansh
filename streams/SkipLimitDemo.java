package test.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SkipLimitDemo {
    public static void main(String[] args) {
        IntStream.range(1, 30)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Take While Result:");
        Stream.of(1, 3, 5, 6, 7, 2, 8, 4, 9)
                .takeWhile(n -> n < 5)
                .forEach(System.out::println);

        System.out.println("Filter Result: ");
        Stream.of(1, 3, 5, 6, 7, 2, 8, 4, 9)
                .filter(n -> n < 5)
                .forEach(System.out::println);
    }
}
