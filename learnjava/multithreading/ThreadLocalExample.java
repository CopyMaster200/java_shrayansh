package learnjava.multithreading;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
        });

        t1.start();
        System.out.println("Main Thread: " + threadLocal.get());
    }
}
