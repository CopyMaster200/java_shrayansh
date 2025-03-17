package javafeatures;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
//        toUpperCase();
//        numberGreaterThanN();
//        findMaxValue();
//        evenSum();
//        groupByLengthOfString();
//        firstEven();
//        mostFrequentCharacter();
//        secondHighestNumber();
//        longestWordInSentence();
//        longestWordInSentenceUsingMax();
//        mostFrequentWordInSentence();
//        findAllWordsWithMaxFrequency();
//        nonRepeatedChar();
//        palindromeStream();
//        secondFrequentCharacter();
//        sumOfDigitsinList();
//        longestWordInSentenceStartsWithLetter();
//        thirdLargestNumber();
//        longestPalindrome();
//        secondFrequentWord();
//        thirdSmallestNumber();
//        longestWordWithVowel();
//        mostFrequentDigitsInNumberList();
//        sumOf2nd3rdLeastNumbers();
//        longestWordStartsWithVowel();
//        secondMostFrequentDigitInNumList();

        /*List<Integer> list = Arrays.asList(2, 3, 4);
        int nth = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
        System.out.println(nth);*/
    }

    private static void secondMostFrequentDigitInNumList() {
        List<Integer> numbers = Arrays.asList(123, 45, 678, 901, 456, 789, 112);
        Map<Character, Long> frequencyMap = numbers.stream()
                .map(Object::toString)
                .flatMap(str -> str.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }

    private static void longestWordStartsWithVowel() {
        String sentence = "Umbrella is essential in autumn and orange trees bloom beautifully";
        String temp = Arrays.stream(sentence.split((" ")))
                .filter(str -> str.matches("^[AEIOUaeiou].*"))
                .max(Comparator.comparing(String::length))
                .orElse("");
        System.out.println(temp);
    }

    private static void sumOf2nd3rdLeastNumbers() {
        List<Integer> numbers = Arrays.asList(8, 3, 10, 3, 5, 6, 8, 2);
        int sum2nd3rd = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum2nd3rd);
    }

    private static void mostFrequentDigitsInNumberList() {
        List<Integer> numbers = Arrays.asList(123, 45, 678, 901, 456, 789);
        Map<Character, Long> freqMap = numbers.stream()
                .map(Object::toString)
                .flatMap(str -> str.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long maxFreq = freqMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();

        List<Character> freqDigits = freqMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxFreq)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(freqDigits);
    }

    private static void longestWordWithVowel() {
        String sentence = "Fly high in the beautiful sky";
        List<String> temp = Arrays.stream(sentence.split(" "))
                .filter(x -> x.matches(".*[aeiouAEIOU].*"))
                .collect(Collectors.toList());
        System.out.println(temp);

        Arrays.stream(sentence.split(" "))
                .filter(x -> x.matches(".*[aeiouAEIOU].*"))
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }

    private static void thirdSmallestNumber() {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 5, 30, 25, 15, 10, 20);
        int thirdSmallestNum = numbers.stream()
                .distinct()
                .sorted()
                .skip(2)
                .findFirst()
                .orElse(-1);
        System.out.println(thirdSmallestNum);
    }

    private static void secondFrequentWord() {
        String sentence = "apple banana apple orange banana apple";
        Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }

    private static void longestPalindrome() {
        String sentence = "level radar racecar java streams";
        String result = Arrays.stream(sentence.split(" "))
                .filter(x -> isPalindrome(x))
                .max(Comparator.comparing(String::length))
                .orElse("");
        System.out.println(result);
    }

    private static boolean isPalindrome(String str) {
        int len = str.length() - 1;
        return IntStream.range(0, len / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(len - i));
    }

    private static void thirdLargestNumber() {
        List<Integer> numbers = Arrays.asList(10, 20, 15, 30, 25);
        int thirdLargest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
        System.out.println(thirdLargest);
    }

    private static void longestWordInSentenceStartsWithLetter() {
        String sentence = "Java Streams make data processing easy";
        char target = 'd';

        Arrays.stream(sentence.split((" ")))
                .filter(x -> x.startsWith("" + target))
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }

    private static void longestWordInSentenceUsingMax() {
        String sentence = "Java Streams make data processing easy";
        Arrays.stream(sentence.split(" "))
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }

    /**
     * Find the Sum of Digits in a List of Numbers Using Streams
     * List<Integer> numbers = Arrays.asList(123, 45, 67, 890);
     * 1+2+3 + 4+5 + 6+7 + 8+9+0 = 45
     */
    private static void sumOfDigitsinList() {
        List<Integer> numbers = Arrays.asList(123, 45, 67, 890);
        int sum = numbers.stream()
                .map(Object::toString)
                .flatMap(str -> str.chars().mapToObj(c -> (char) c))
                .map(Character::getNumericValue)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }

    private static void secondFrequentCharacter() {
        String input = "successes";
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequencyMap);

        frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst().ifPresent(x -> System.out.println("Second frequent character in the String: " + x.getKey()));
    }

    private static void palindromeStream() {
        String str = "sos";
        int len = str.length();
        boolean palindrome = Stream.iterate(0, n -> n + 1)
                .limit(len / 2)
                .noneMatch(x -> str.charAt(x) != str.charAt(len - 1 - x));

        System.out.println(palindrome ? "Palindrome" : "Not a palindrome");
    }

    private static void nonRepeatedChar() {
        String input = "swiss";
        input.chars()
                .filter(x -> input.indexOf(x) == input.lastIndexOf(x))
                .findFirst()
                .ifPresent(x -> System.out.println((char) x));
    }

    private static void findAllWordsWithMaxFrequency() {
        String sentence = "red blue red green blue green";
        Map<String, Long> frequencyMap = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long maxFrequency = frequencyMap.values().stream()
                .max(Long::compare)
                .orElse(0L);

        List<String> mostFrequentWords = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(mostFrequentWords);
    }

    private static void mostFrequentWordInSentence() {
        String sentence = "apple banana apple orange banana apple";
        Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }

    private static void longestWordInSentence() {
        String sentence = "Java streams are very powerful for data processing";
        List<String> list = Arrays.asList(sentence.split(" "));
        Map<Integer, List<String>> map = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);
        Optional<Map.Entry<Integer, List<String>>> entry = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .findFirst();
        entry.ifPresent(x -> System.out.println(x.getValue()));

        map.entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .ifPresent(System.out::println);

        System.out.println("New impl");
        Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .ifPresent(x -> System.out.println(x.getValue()));

    }

    private static void secondHighestNumber() {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 8, 25, 20, 15);
        System.out.println(numbers);
        int secondHigh = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println(secondHigh);

        int secondMax = numbers.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .sorted()
                .limit(numbers.size() - 1L)
                .max()
                .orElse(-1);
        System.out.println(secondMax);
    }

    private static void mostFrequentCharacter() {
        String input = "java programming";
        Map<Character, Long> temp = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(temp);

        Optional<Map.Entry<Character, Long>> sorted = temp.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
//                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
//                .findFirst();
        sorted.ifPresent(entry -> System.out.println("Most Frequent Character: " + entry.getKey() + " ( " + entry.getValue() + " times)"));

        long value = temp.entrySet().stream().mapToLong(Map.Entry::getValue).max().orElse(-1);
        System.out.println(value);
    }

    private static void firstEven() {
        List<Integer> numbers = Arrays.asList(7, 15, 9, 12, 18, 25);
        int firstEvenNum = numbers.stream()
                .filter(x -> x % 2 == 0)
                .findFirst()
                .orElse(-1);
        System.out.println(firstEvenNum);
    }

    private static void groupByLengthOfString() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "dog", "elephant");
        Map<Integer, List<String>> group = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(group);
    }

    private static void evenSum() {
        List<Integer> numbers = Arrays.asList(5, 12, 18, 7, 25, 3, 10);
        int evenSum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(evenSum);
    }

    private static void findMaxValue() {
        List<Integer> numbers = Arrays.asList(5, 12, 18, 7, 25, 3, 10);
        int max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(-1);
        System.out.println(max);
    }

    private static void numberGreaterThanN() {
        List<Integer> numbers = Arrays.asList(5, 12, 18, 7, 25, 3, 10);
        long count = numbers.stream()
                .filter(num -> num > 10)
                .count();
        System.out.println(count);
    }

    private static void toUpperCase() {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Amanda");
        List<String> uppercase = names.stream()
                .filter(str -> str.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(uppercase);
    }
}
