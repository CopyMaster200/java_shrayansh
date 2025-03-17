package learnjava;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * Splitting Rules
 * If the collection is large, trySplit() will attempt a near 50-50 split.
 * If the collection is small, it may return null (no further splitting).
 * If repeatedly called, it keeps splitting the remaining part, making it useful for parallel execution.
 */
public class SpliteratorDemo {
    public static void main(String[] args) {
        spliterator();
//        parallelSpliterator();
    }

    private static void spliterator() {
        List<String> names = List.of("A", "B", "C", "D", "E", "F", "G", "H");
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> firstHalf = spliterator.trySplit();
        System.out.println("First Half: ");
        firstHalf.forEachRemaining(System.out::println);

        System.out.println("Second Half: ");
        spliterator.forEachRemaining(System.out::println);
    }

    private static void parallelSpliterator() {
        List<String> customers = Arrays.asList(
                "Alice", "Bob", "Charlie", "David", "Emma", "Frank",
                "Grace", "Hannah", "Ivy", "Jack", "Kevin", "Liam"
        );

        // Convert list to a stream and use parallel processing
        customers.parallelStream().forEach(name ->
                System.out.println(Thread.currentThread().getName() + " - " + name)
        );
    }
}
