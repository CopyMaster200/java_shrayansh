package learnjava.multithreading;

import java.util.concurrent.locks.StampedLock;

public class StampedOptimisticResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void produce() {
        long stamp = lock.tryOptimisticRead();
        System.out.println("Taken optimistic read : " + Thread.currentThread().getName() + " stamp: " + stamp);
        try {
            a = 11;
            Thread.sleep(6000);
            if (lock.validate(stamp)) {
                System.out.println("updated successfully!");
            } else {
                System.out.println("Rollback update");
                a = 10;
            }
        } catch (InterruptedException e) {
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
