package learnjava.multithreading;

/**
 * Daemon thread will alive until at least one of the user thread is alive.
 * Garbage collector is a daemon thread.
 */
public class DeamonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "Started");

        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                System.out.println(Thread.currentThread().getName() + " : " + i);
        });

        t.setDaemon(true);
        t.start();
        System.out.println(Thread.currentThread().getName() + "Completed");
    }
}
