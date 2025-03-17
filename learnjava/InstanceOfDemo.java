package learnjava;

class Parent {
    String parent = "Parent";
}

class Child1 extends Parent {

}

class Child2 extends Child1 {

}

public class InstanceOfDemo {
    public static void main(String[] args) {
        Child2 obj = new Child2();
        System.out.println(obj instanceof Parent);
    }
}
