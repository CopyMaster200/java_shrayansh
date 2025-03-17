package test.datastructures;

import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "(())";
        String test2 = "(()";
        String test3 = "((((";

        System.out.println(test1 + " is balanced? " + isBalanced(test1)); // true
        System.out.println(test2 + " is balanced? " + isBalanced(test2)); // false
        System.out.println(test3 + " is balanced? " + isBalanced(test3)); // false
    }
}
