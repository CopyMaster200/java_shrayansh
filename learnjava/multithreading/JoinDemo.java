package learnjava.multithreading;

import java.util.stream.IntStream;

public class JoinDemo {
    public static void main(String[] args) {
        System.out.println("Main Thread starts: " + Thread.currentThread().getName());

        Thread t = new Thread(() -> IntStream.range(1, 11).map(x -> 1 << x).forEach(x -> {
            System.out.println(Thread.currentThread().getName() + " : " + x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
        }
        System.out.println("Main Thread ends: " + Thread.currentThread().getName());
    }
}
