package test.programs;

import java.util.Stack;

/**
 * You are given a string that represents the postfix form of a valid mathematical expression.
 * Convert it to its infix form.
 * Example:
 * Input:
 * ab*c+
 * Output:
 * ((a*b)+c)
 * Explanation:
 * The above output is its valid infix form.
 */
public class PostToInfix {
    static String postToInfix(String exp) {
        if (exp == null || exp.isEmpty()) return exp;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (isOperator(ch)) {
                String second = stack.pop();
                String first = stack.pop();
                String temp = "(" + first + ch + second + ")";
                stack.push(temp);
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char op) {
        return "*/+-".indexOf(op) != -1;
    }

    public static void main(String[] args) {
        String exp = "ab*c+";
        System.out.println(postToInfix(exp));  // Output: ((a*b)+c)
    }
}
