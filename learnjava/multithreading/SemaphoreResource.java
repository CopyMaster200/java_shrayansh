package learnjava.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreResource {
    Semaphore lock = new Semaphore(2);

    public void produce() {
        try {
            lock.acquire();
            System.out.println("Locked by: " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
        } finally {
            System.out.println("Released by: " + Thread.currentThread().getName());
            lock.release();
        }
    }
}
