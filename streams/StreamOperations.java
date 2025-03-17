package test.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 5, 20, 8, 15);
        int redSum = numbers.stream()
                .reduce(0, Integer::sum);  // Initial value 0, summing elements
        System.out.println(redSum);  // Output: 58

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = nums.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Collectors.summing Sum: " + sum);

        IntSummaryStatistics stats = nums.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("mapToInt summary stats: " + stats);

        int sum1 = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("mapToInt sum: " + sum1);

        int sum2 = nums.stream().reduce(0, Integer::sum);
        System.out.println("reduce sum: " + sum2);

        nums.stream().collect(Collectors.summarizingInt(Integer::intValue)).getSum();

        int a[] = {1, 2, 3, 4, 5};
        int arrSum = Arrays.stream(a).sum();
        System.out.println(arrSum);

        Stream.of(1, 2, 3, 4).mapToInt(Integer::intValue).summaryStatistics();

        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("wordcount" + wordCount); // Output: {apple=3, banana=2, orange=1}

        List<String> fruits = List.of("Apple", "Banana", "Cherry");
        Map<String, Integer> fruitLengthMap = fruits.stream()
                .collect(Collectors.toMap(fruit -> fruit, String::length));
        System.out.println("character count: " + fruitLengthMap);  // Output: {Apple=5, Banana=6, Cherry=6}

        List<String> fruitsList = List.of("Apple", "Banana", "Cherry", "Avocado", "Blueberry");
        Map<Character, List<String>> map = fruitsList.stream().collect(Collectors.groupingBy(x -> x.charAt(0)));
        System.out.println(map);

        List<Integer> evenNums = Stream.iterate(0, n -> n + 2).skip(1).limit(10).collect(Collectors.toList());
        System.out.println("Even Numbers:" + evenNums);

        Random random = new Random();
        List<Integer> randNums = Stream.generate(() -> random.nextInt(9) + 1) // Generates random integers between 1 and 9
                .limit(10) // Limits the stream to 10 integers
                .collect(Collectors.toList()); // Collects into a list
        System.out.println("randNums: " + randNums);

        List<Integer> sortedDescending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedDescending);  // Output: [20, 15, 10, 8, 5]

        List<Integer> numb = List.of(10, 5, 20, 8, 15);
        Optional<Integer> maxNumber = numb.stream()
                .max(Integer::compare);
        maxNumber.ifPresent(System.out::println);  // Output: 20

        Optional<Integer> minNumber = numb.stream()
                .min(Integer::compare);
        minNumber.ifPresent(System.out::println);  // Output: 5
    }
}
