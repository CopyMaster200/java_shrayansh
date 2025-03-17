package learnjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Heap Pollution with Varargs.
 * Object of one type holding the reference of different type object
 * In this example we are holding the ref of String obj type in the varargs of Integer type.
 */
public class Log {

    @SafeVarargs
    public static void printLogValues(List<Integer>... logValues) {

        Object[] objects = logValues;

        List<String> strings = new ArrayList<>();
        strings.add("Heap Pollution");

        System.out.println("Before Heap Pollution:\n" + Arrays.toString(objects));

        // Here I am replacing the 0 index List<Integer> with List<String> which is called Heap pollution.
        objects[0] = strings;

        // Here you will expect Integer type based on the argument declaration as Integer.
        // Since it is polluted with different types which lead us to ClassCastException.
        Integer test = logValues[0].get(0);

        System.out.println("Before Heap Pollution:\n" + Arrays.toString(objects));
    }

    public static void main(String[] args) {
        printLogValues(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
    }
}
