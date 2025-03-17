package test.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class DropWhileTakeWhile {
    public static void main(String[] args) {
        Class<?> clazz = ArrayList.class;

//        clazz.getSuperclass();
        Stream.<Class<?>>iterate(clazz, aClass -> aClass.getSuperclass())
                .takeWhile(aClass -> null != aClass)
                .forEach(System.out::println);
    }
}
