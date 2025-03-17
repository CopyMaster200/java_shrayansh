package test.oracle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortLinkedLists {
    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>(); // [9,7,5,3]
        l1.add(9);
        l1.add(7);
        l1.add(5);
        l1.add(3);
        l1.add(1);

        List<Integer> l2 = new LinkedList<>(); // [8,6,4,2]
        l2.add(8);
        l2.add(6);
        l2.add(4);
        l2.add(2);

        System.out.println(l1);
        System.out.println(l2);

        Collections.sort(l1);
        Collections.sort(l2);
        sortBoth(l1, l2);
    }

    private static void sortBoth(List<Integer> l1, List<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        int s1 = 0, s2 = 0;
        while (s1 < l1.size() || s2 < l2.size()) {
            if(s1 == l1.size()) {
                result.addAll(l2.subList(s2,l2.size()));
                break;
            } else if (s2 == l2.size()) {
                result.addAll(l1.subList(s1,l1.size()));
                break;
            }
            if(l1.get(s1) < l2.get(s2)) {
                result.add(l1.get(s1));
                s1++;
            } else {
                result.add(l2.get(s2));
                s2++;
            }
        }
        System.out.println(result);
    }
}
