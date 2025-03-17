package learnjava.collection;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        hashMap();
        linkedHashMapDemo();
        treeMap();
    }

    private static void treeMap() {
        Map<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(1, "A");
        sortedMap.put(21, "B");
        sortedMap.put(23, "C");
        sortedMap.put(141, "D");
        sortedMap.put(25, "E");

        System.out.println("Sorted Map: " + sortedMap);

        Set<Integer> set = new HashSet<>();
        set.add(1);
    }

    private static void hashMap() {
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(null, "ZERO");
        studentMap.put(0, null);
        studentMap.put(1, "A");
        studentMap.put(2, "B");

        System.out.println("Student Map: " + studentMap);

        // compute if absent
        studentMap.putIfAbsent(null, "test");
        studentMap.putIfAbsent(0, "Replace"); // It will add entry if key is not associated with any of the value

        System.out.println("Student Map: " + studentMap);
    }

    private static void linkedHashMapDemo() {
        Map<Integer, String> defaultMap = new LinkedHashMap<>();
        defaultMap.put(1, "A");
        defaultMap.put(21, "B");
        defaultMap.put(23, "C");
        defaultMap.put(141, "D");
        defaultMap.put(25, "E");

        defaultMap.get(23);
        System.out.println("Default LinkedHashMap order: " + defaultMap);

        Map<Integer, String> frequentMap = new LinkedHashMap<>(16, 0.75F, true);
        frequentMap.put(1, "A");
        frequentMap.put(21, "B");
        frequentMap.put(23, "C");
        frequentMap.put(141, "D");
        frequentMap.put(25, "E");

        frequentMap.get(23);
        System.out.println("Access Order LinkedHashMap order: " + frequentMap);
    }
}
