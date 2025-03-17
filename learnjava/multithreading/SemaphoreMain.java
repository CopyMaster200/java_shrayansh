package learnjava.multithreading;

public class SemaphoreMain {
    public static void main(String[] args) {
        SemaphoreResource resource = new SemaphoreResource();

        Thread t1 = new Thread(() -> {
            resource.produce();
        });

        Thread t2 = new Thread(() -> {
            resource.produce();
        });

        Thread t3 = new Thread(() -> {
            resource.produce();
        });

        Thread t4 = new Thread(() -> {
            resource.produce();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
