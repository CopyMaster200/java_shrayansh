package test.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeStack {
    public static void main(String[] args) {
        String str = "ABBA";
        System.out.println(checkPalindrome(str));
        System.out.println(checkPali(str));
        System.out.println(isPalindrome(str));
    }

    private static boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString().equals(str);
    }

    private static boolean checkPali(String str) {
        // ABA
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
