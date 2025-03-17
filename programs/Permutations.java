package test.programs;

import java.util.HashSet;
import java.util.Set;

public class Permutations {
    public static Set<String> find_permutation(String s) {
        Set<String> result = new HashSet<>();
        permute(s, "", result);
        return result; // Remove duplicates
    }

    private static void permute(String s, String chosen, Set<String> result) {
        if (s.isEmpty()) {
            result.add(chosen);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            permute(s.substring(0, i) + s.substring(i + 1), chosen + s.charAt(i), result);
        }
    }

    public static void main(String[] args) {
        System.out.println(find_permutation("ABC"));  // [ABC, ACB, BAC, BCA, CAB, CBA]
        System.out.println(find_permutation("AAB"));  // [AAB, ABA, BAA]
    }
}
