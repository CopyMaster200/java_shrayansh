package learnjava.multithreading;

public class SharedResource {

    boolean stock;

    public synchronized void addItem() {
        stock = true;
        System.out.println("Item added by " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void removeItem() {
        while (!stock) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now.");
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Item consumed by thread " + Thread.currentThread().getName());
        stock = false;
    }
}
