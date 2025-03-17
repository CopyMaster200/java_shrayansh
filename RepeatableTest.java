package learnjava;

public class RepeatableTest {
    public static void main(String[] args) {
        Category[] annotations = new Eagle().getClass().getDeclaredAnnotationsByType(Category.class);
        for (Category category : annotations) {
            System.out.println(category);
        }
    }
}
