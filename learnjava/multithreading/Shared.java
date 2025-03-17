package learnjava.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class Shared {
    // Static lock shared across all instances of the class
    private static final ReentrantLock lock = new ReentrantLock();

    public void action() {
        try {
            lock.lock(); // Only one thread across all instances can lock at a time
            System.out.println("Locked by: " + Thread.currentThread().getName());
            // Simulating some work
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted state
        } finally {
            lock.unlock(); // Release the lock
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }
}