package learnjava;

@CustomAnnotation
public class TestCustomAnnotation {
    public static void main(String[] args) {
        //Here we can see out custom annotation has been a part of declared annotation
        System.out.println(new TestCustomAnnotation().getClass().getDeclaredAnnotations());
    }
}
