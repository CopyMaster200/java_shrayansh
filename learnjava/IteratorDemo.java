package learnjava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class IteratorDemo {

    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);

        Iterator<Integer> it = num.iterator();
        int value;
        while (it.hasNext()) {
            value = it.next();
            System.out.println(value);
            if ((value & 1) == 1) {
                //remove odd
                it.remove();
            }
        }

        System.out.println("Final even list: " + num);

    }
}
