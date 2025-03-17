package test.programs;

import java.util.Stack;

/**
 * You are given an array of strings arr that represents a valid arithmetic expression written in Reverse Polish Notation
 * (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.
 *
 * Key Details:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand is guaranteed to be a valid integer or another expression.
 * The division operation between two integers always rounds the result towards zero, discarding any fractional part.
 * No division by zero will occur in the input.
 * The input is a valid arithmetic expression in Reverse Polish Notation.
 * The result of the expression and all intermediate calculations will fit in a 32-bit signed integer.
 *
 * Examples:
 * Input: arr = ["5", "3", "4", "*", "+"]
 * Output: 17
 * Explanation: (5 + (3 * 4)) = 17
 *
 * Input: arr = ["-8", "3", "/"]
 * Output: -2
 * Explanation: (-8 / 3) = -2. Division rounds towards zero, so -8 divided by 3 gives -2 (not -2.666...).
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        ReversePolishNotation sol = new ReversePolishNotation();
        String[] arr = {"5", "3", "4", "*", "+"};
        System.out.println(sol.evaluate(arr)); // Output: 17
    }

    public int evaluate(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {
            if (isOperator(token)) {
                // Pop two numbers from the stack
                int b = stack.pop();
                int a = stack.pop();

                // Evaluate and push result
                stack.push(applyOperator(a, b, token));
            } else {
                // Push number onto stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result will be at the top of the stack
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // Assuming valid input (no division by zero)
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
