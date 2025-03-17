package learnjava.multithreading;

public class StampedDemo {
    public static void main(String[] args) {
        SharedStamped stampedResource1 = new SharedStamped();

        Thread t1 = new Thread(() -> {
            stampedResource1.produce();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            stampedResource1.produce();
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            stampedResource1.consume();
        });
        t3.start();
    }
}
