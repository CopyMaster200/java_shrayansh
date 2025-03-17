package bitwise;

public class BitwiseEvenOdd {
    public static void main(String[] args) {
        int num = 7;

        if ((num & 1) == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
    }
}

