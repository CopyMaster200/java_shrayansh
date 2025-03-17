package learnjava.multithreading;

import java.util.concurrent.locks.StampedLock;

public class SharedStamped {
    StampedLock lock = new StampedLock();

    public void produce() {
        long stamp = lock.readLock();
        System.out.println("Locked by: " + Thread.currentThread().getName() + " stamp: " + stamp);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        } finally {
            lock.unlockRead(stamp);
            System.out.println("Unlocked by: " + Thread.currentThread().getName() + " stamp: " + stamp);
        }
    }

    public void consume() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Locked by: " + Thread.currentThread().getName() + " stamp: " + stamp);
        } catch (Exception e) {
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Unlocked by: " + Thread.currentThread().getName() + " stamp: " + stamp);
        }
    }
}
