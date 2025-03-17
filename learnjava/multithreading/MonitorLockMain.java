package learnjava.multithreading;

public class MonitorLockMain {
    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();

        Thread t1 = new Thread(() -> obj.task1()); // First t1 will acquire the monitor lock on obj sleep for 10000
        Thread t2 = new Thread(() -> obj.task2()); // Will complete non-sync statements and try to acquire lock on obj.
                                                    // Since the lock is with t1, t2 will wait for its turn.
        Thread t3 = new Thread(() -> obj.task3()); // No Sync blocks or methods, so it will execute without any issue/waiting

        t1.start();
        t2.start();
        t3.start();
    }
}
