package learnjava.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class SetDemo {
    static String decor = "#".repeat(50);

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        Set<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(3);
        hashSet1.add(4);
        hashSet1.add(5);

        hashSet(hashSet, hashSet1);

//        Set<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
    }

    private static void hashSet(Set<Integer> hashSet1, Set<Integer> hashSet2) {
        System.out.println(decor);
        System.out.println("When duplicates are added the put will return: " + hashSet1.add(1));
        System.out.println("Hashset: " + hashSet1);

        System.out.println(decor);
        System.out.println("set1: "+hashSet1 +" set2: "+hashSet2);
        hashSet1.addAll(hashSet2);
        System.out.println("addAll - union of set1 & set2: "+ hashSet1);
        hashSet2.add(6);
        hashSet2.add(7);

        System.out.println(decor);
        System.out.println("set1: "+hashSet1 +" set2: "+hashSet2);
        hashSet1.retainAll(hashSet2);
        System.out.println("retainAll - common elements in set1 & set2: "+ hashSet1);

        System.out.println(decor);
        System.out.println("set1: "+hashSet1 +" set2: "+hashSet2);
        hashSet1.removeAll(hashSet2);
        System.out.println("removeAll - removes elements in set2 from set1: "+hashSet1);
    }
}
