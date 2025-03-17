package bitwise;

public class BitwiseDemo {
    public static void main(String[] args) {
        int a = 1, b = 2; // 1 = 0001, 2 = 0010
        System.out.println(a & b); // 0001 0010 -> 0000
        System.out.println(a | b); // 0001 0010 -> 0011
        System.out.println(a ^ b); // 0001 0010 -> 0011
        System.out.println(~a); // -(n+1) -> -2


    }
}
