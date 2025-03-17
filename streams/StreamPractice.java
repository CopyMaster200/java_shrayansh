package test.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        squareEvenNumbersAsc();
        secondLargestUniqueNumber();
        findWordContainingLetter();
        mostFrequentWord();
        groupingAndSummingNumbers();
        wordsGroupedByFirstCharacter();
        findTheLongestWords();
    }

    /**
     * You are given a list of strings containing words. Your task is to find the longest word(s) in the list and return them in a list.
     * If multiple words have the same maximum length, return all of them.
     */
    private static void findTheLongestWords() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry", "strawberry", "kiwi");
        Map<Integer, List<String>> map = words.stream()
                .collect(Collectors.groupingBy(String::length));

        List<String> maxList = map.entrySet().stream().sorted((x, y) -> y.getKey().compareTo(x.getKey())).map(Map.Entry::getValue).findFirst().orElse(new ArrayList<>());
        System.out.println(maxList);

        int length = words.stream().mapToInt(String::length).max().orElse(0);
        List<String> res = words.stream().filter(word -> word.length() == length).collect(Collectors.toList());
        System.out.println(res);

        List<String> longestWords = words.stream()
                .collect(Collectors.groupingBy(String::length))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList());
        System.out.println(longestWords);

    }

    /**
     * Your task is to group them by their first letter
     * Input:
     * ("apple", "banana", "apricot", "blueberry", "avocado", "blackberry", "cherry")
     * output:
     * {a=[apple, apricot, avocado], b=[banana, blueberry, blackberry], c=[cherry]}
     */
    private static void wordsGroupedByFirstCharacter() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado", "blackberry", "cherry");
        Map<Character, List<String>> result = words.stream()
                .collect(Collectors.groupingBy(x -> x.charAt(0)));
        System.out.println(result);
    }

    /**
     * Given a list of numbers, group them into odd and even numbers and find the sum of each group.
     * <p>
     * Example Input:
     * List<Integer> numbers = Arrays.asList(4, 7, 2, 9, 1, 8, 5);
     * Expected Output:
     * {EVEN=14, ODD=22}
     */
    private static void groupingAndSummingNumbers() {
        List<Integer> numbers = Arrays.asList(4, 7, 2, 9, 1, 8, 5);
        Map<String, Integer> result = numbers.stream()
                .collect(Collectors.groupingBy(num -> (num % 2 == 0) ? "EVEN" : "ODD",
                        Collectors.summingInt(Integer::intValue)));
        System.out.println(result+"\n");
    }

    private static void squareEvenNumbersAsc() {
        int[] arr = {4, 3, 1, 6, 8, 7};
        int[] result = Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .sorted()
                .toArray();
        System.out.println("squareEvenNumbersAsc: " + Arrays.toString(result));
        System.out.println();
    }

    private static void secondLargestUniqueNumber() {
        List<Integer> nums = Arrays.asList(5, 3, 1, 5, 7, 3, 8);
        // List<Integer> nums = Arrays.asList(4, 4, 4);
        List<Integer> result = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        int retVal = result.size() == 1 ? result.get(0) : -1;
        System.out.println("secondLargestUniqueNumber: " + retVal);
        System.out.println();
    }

    /**
     * Find Words Containing a Given Letter
     * You are given a list of words and a character ch.
     * Return a list of words that contain the character ch, sorted in ascending order.
     * Request:
     * words = ["apple", "banana", "cherry", "grape", "mango"]
     * ch = 'a'
     * Response:
     * ["apple", "banana", "grape", "mango"]
     */
    private static void findWordContainingLetter() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "grape", "mango");
        char ch = 'a';

        List<String> result = words.stream()
                .filter(word -> word.contains("" + ch))
//                .filter(word -> word.indexOf(ch) != -1) //using index also we can find out character
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    /**
     * You are given a list of words. Your task is to find the word that appears the most times.
     * If multiple words have the same highest frequency, return the lexicographically smallest one.
     * Input:
     * words = ["apple", "banana", "apple", "orange", "banana", "apple"]
     * Output:
     * "apple"
     */
    private static void mostFrequentWord() {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> result = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String retVal = result.entrySet()
                .stream()
                .max(Comparator.comparing((Map.Entry<String, Long> entry) -> entry.getValue()) // Explicit type
                        .thenComparing(Map.Entry::getKey)) // Break ties lexicographically
                .map(Map.Entry::getKey)
                .orElse(""); // Default value if no words

        System.out.println(result);
        System.out.println("mostFrequentWord using comparator: " + retVal);
        // Sort by value in descending order and get the first key
        String mostFrequentWord = result.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort by value (desc)
                .map(Map.Entry::getKey) // Extract key
                .findFirst() // Get first element
                .orElse(""); // Default if no words

        System.out.println("mostFrequentWord using sort: " + mostFrequentWord);
        System.out.println();

    }
}
