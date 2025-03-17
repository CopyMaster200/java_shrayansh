package learnjava.multithreading;

class ChildThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Child Thread: " + Thread.currentThread().getName());
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main Thread: " + Thread.currentThread());

        ChildThread target = new ChildThread();
        Thread thread = new Thread(target);
        thread.start();
    }
}
