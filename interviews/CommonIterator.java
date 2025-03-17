package interviews;

import java.util.*;
import java.util.stream.Stream;

public class CommonIterator {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Suresh");
        map.put(2, "Mahesh");
        map.put(3, "Ramesh");

        iterate(map);
        iterate(nums);
        iterateByStream(nums);
        iterateByStream(map);
    }

    private static void iterateByStream(Object object) {
        System.out.println("Iterating "+object.getClass().getSimpleName());
        Stream.of(object).forEach(System.out::println);
    }

    private static void iterate(Object object) {
        if (object instanceof Map) {
            System.out.println("Iterating map: ");
            Map<?, ?> map = (Map<?, ?>) object;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry);
            }

        } else if (object instanceof Collection) {
            System.out.println("Iterating collection: ");
            Iterator<?> iterator = ((Collection<?>) object).iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
