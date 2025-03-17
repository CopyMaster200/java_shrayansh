package test.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.
 *
 * Examples:
 * Input: s = "ABC"
 * Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 * Explanation: Given string ABC has 6 unique permutations.
 * Input: s = "ABSG"
 * Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
 * Explanation: Given string ABSG has 24 unique permutations.
 * Input: s = "AAA"
 * Output: ["AAA"]
 * Explanation: No other unique permutations can be formed as all the characters are same.
 * Constraints:
 * 1 <= s.size() <= 9
 * s contains only Uppercase english alphabets
 *
 * Simple Approach: Using Recursion + TreeSet
 * A TreeSet stores only unique values and maintains lexicographical order.
 * We swap characters recursively to generate permutations.
 */
public class FindPermutation {
    public static List<String> find_permutation(String s) {
        Set<String> set = new TreeSet<>();  // TreeSet removes duplicates and sorts results
        permute(s.toCharArray(), 0, set);
        return new ArrayList<>(set);  // Convert Set to List
    }

    private static void permute(char[] chars, int index, Set<String> set) {
        if (index == chars.length) {
            set.add(new String(chars)); // Add unique permutation
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);  // Swap
            permute(chars, index + 1, set);
            swap(chars, i, index);  // Backtrack (undo swap)
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(find_permutation("ABC"));  // ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
        System.out.println(find_permutation("ABSG")); // 24 permutations
        System.out.println(find_permutation("AAA"));  // ["AAA"]
    }
}
