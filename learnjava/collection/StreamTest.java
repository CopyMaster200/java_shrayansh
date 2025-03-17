package learnjava.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        waysToCreateStream();
//        flatMap();
//        terminalOperations();

        List<Integer> nums = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);
        System.out.println("" + nums);
        Long streamStartTime = System.currentTimeMillis();

        nums.stream()
                .map(x -> x * x)
                .forEach(System.out::println);
        System.out.println("Time taken for stream() : " + (System.currentTimeMillis() - streamStartTime) + "ms");

        Long parallelStartTime = System.currentTimeMillis();
        nums.parallelStream()
                .map(x -> x * x)
                .forEach(System.out::println);
        System.out.println("Time taken for parallel stream() : " + (System.currentTimeMillis() - parallelStartTime) + "ms");

    }

    private static void terminalOperations() {
        List<Integer> nums = Arrays.asList(2, 1, 4, 7, 10);
        System.out.println(nums);
        int min = nums.stream()
                .min(Comparator.comparingInt((var a) -> a))
                .orElse(-1);
        System.out.println("MIN: " + min);

        int max = nums.stream()
                .max(Comparator.comparingInt((var a) -> a))
                .orElse(-1);
        System.out.println("MAX: " + max);

        boolean anyMatch = nums.stream().anyMatch(x -> x > 3);
        System.out.println("anyMatch: " + anyMatch); // true

        boolean allMatch = nums.stream().allMatch(x -> x > 3);
        System.out.println("allMatch: " + allMatch); // false

        boolean noneMatch = nums.stream().noneMatch(x -> x > 3);
        System.out.println("noneMatch: " + noneMatch); // false
    }

    private static void flatMap() {
        List<List<String>> sentence = Arrays.asList(
                Arrays.asList("I", "LOVE", "JAVA 8"),
                Arrays.asList("CONCEPTS", "ARE", "CLEAR"),
                Arrays.asList("ITS", "VERY", "EASY")
        );

        List<String> flatList = sentence.stream()
                .flatMap((List<String> line) -> line.stream())
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println("First Way " + flatList);

        List<String> flatAndApply = sentence.stream()
                .flatMap((List<String> line) -> line.stream().map(String::toLowerCase))
                .collect(Collectors.toList());

        System.out.println("Second Way " + flatAndApply);
    }

    private static void waysToCreateStream() {
        // Different ways to create stream

        // From Collection
        List<Integer> nums = Arrays.asList(3000, 4000, 9000, 1000, 4500);
        Stream<Integer> numStream = nums.stream();

        // From Array
        Integer[] arr = {3000, 4000, 9000, 1000, 4500};
        Stream<Integer> arrStream = Arrays.stream(arr);

        // From static method of stream with varargs
        Stream<Integer> streamOf = Stream.of(3000, 4000, 9000, 1000, 4500);

        // Stream builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(3000).add(4000).add(9000).add(1000).add(4500);
        Stream<Integer> builderStream = streamBuilder.build();

        // From Stream iterate
        Stream<Integer> iterate = Stream.iterate(1000, (Integer x) -> x + 5000).limit(5);
    }
}
