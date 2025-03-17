package test.streams;

import java.util.stream.IntStream;

public class PaliDemo {
    public static void main(String[] args) {
        String str = "sos";
//        palindrome(str);
//        palindromeStream(str);
        palindromeWhile(str);
    }

    private static void palindromeWhile(String str) {
        int i =0, j = str.length()-1;
        boolean flag = true;
        while(i<j) {
            if(str.charAt(i) != str.charAt(j)) {
                flag=false;
                break;
            }
            i++;j--;
        }
        System.out.println(flag);
    }

    private static void palindromeStream(String str) {
        int len = str.length();
        boolean result = IntStream.range(0, str.length() / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(len - i - 1));
        System.out.println(result);
    }

    private static void palindrome(String str) {
        int len = str.length();
        if (len == 1) {
            System.out.println(true);
            return;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
