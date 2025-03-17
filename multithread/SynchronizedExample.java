package multithread;

/**
 * When multiple threads access shared resources, race conditions can occur.
 * Synchronization ensures only one thread accesses a critical section at a time.
 */
class SharedResource {
    synchronized void printNumbers() { // Synchronized method
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread t1 = new Thread(() -> obj.printNumbers());
        Thread t2 = new Thread(() -> obj.printNumbers());

        t1.start();
        t2.start();
    }
}
