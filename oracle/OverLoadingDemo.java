package test.oracle;

public class OverLoadingDemo {
    public static void main(String[] args) {
        print((String) null);
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(Long var) {
        System.out.println(var);
    }
}
