package learnjava.multithreading;

public class MonitorLockExample {
    public synchronized void task1() {
        System.out.println("Inside task1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void task2() {
        System.out.println("Inside task2 before synchronized");
        synchronized (this) {
            System.out.println("Inside task2 synchronized block");
        }
    }

    public void task3() {
        System.out.println("Inside task3");
    }
}
