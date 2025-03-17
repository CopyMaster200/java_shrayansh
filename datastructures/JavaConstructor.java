package datastructures;

public class JavaConstructor {

    JavaConstructor() {
        super();
        System.out.println("I'm constructor");
    }

    public JavaConstructor JavaConstructor() {
        return new JavaConstructor();
    }

    public static void main(String[] args) {
        JavaConstructor jc = new JavaConstructor();
        jc.JavaConstructor();
    }
}
