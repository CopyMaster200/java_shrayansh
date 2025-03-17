package learnjava.multithreading.atomic;

import java.util.stream.IntStream;

public class VolatileCountMain {
    public static void main(String[] args) throws InterruptedException {
        VolatileCount count = new VolatileCount();

        Thread t1 = new Thread(() -> {
            IntStream.range(1, 11).forEach(x -> count.increment());
        });

        Thread t2 = new Thread(() -> {
            IntStream.range(1, 11).forEach(x -> count.increment());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.getCount());
    }
}
