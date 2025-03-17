package learnjava.multithreading.atomic;

public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++)
                counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++)
                counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}
