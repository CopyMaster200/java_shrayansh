package learnjava.multithreading;


public class ReentrantLockDemo {
    public static void main(String[] args) {
        Shared r1 = new Shared(); // First instance
        Shared r2 = new Shared(); // Second instance

        Thread t1 = new Thread(r1::action); // Uses shared lock
        Thread t2 = new Thread(r2::action); // Uses shared lock

        t1.start();
        t2.start();
    }
}
