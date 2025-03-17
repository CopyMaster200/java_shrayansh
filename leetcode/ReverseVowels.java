package test.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ReverseVowels {
    public static Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm")); // Expected: "AceCreIm"
        System.out.println(removeVowels("IceCreAm"));
    }

    private static String removeVowels(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !vowel.contains(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String reverseVowels(String s) {

        int i = 0, j = s.length() - 1;

        char[] chars = s.toCharArray();
        while (i < j) {
            if (vowel.contains(s.charAt(i))) {
                if (vowel.contains(s.charAt(j))) {
                    swap(chars, i, j);
                    i++;
                }
                j--;
            } else if (!vowel.contains(s.charAt(i))) {
                if (!vowel.contains(s.charAt(j))) {
                    j--;
                }
                i++;
            }

        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
