package interviews;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddThread {
    private static final int MAX = 10;
    private static final Object LOCK = new Object();
    private static int num = 1;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable even = () -> {
            while (num <= MAX) {
                synchronized (LOCK) {
                    if (num % 2 == 0) {
                        System.out.println(num + " is even");
                        num++;
                        LOCK.notify();
                    } else {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Runnable odd = () -> {
            while (num <= MAX) {
                synchronized (LOCK) {
                    if (num % 2 != 0) {
                        System.out.println(num + " is odd");
                        num++;
                        LOCK.notify();
                    } else {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        executorService.submit(even);
        executorService.submit(odd);

        executorService.shutdown();
    }
}
