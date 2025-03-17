package learnjava.multithreading;

public class SharedResourceMain {
    public static void main(String[] args) {
        System.out.println("Main thread started.");
        SharedResource shared = new SharedResource();

        Thread producer = new Thread(() -> {
            System.out.println("Producer thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
                shared.addItem();
            } catch (InterruptedException e) {
            }
        });

        Thread consumer = new Thread(() -> {
            System.out.println("Consumer Thread: " + Thread.currentThread().getName());
            shared.removeItem();
        });

        producer.start();
        consumer.start();

        System.out.println("Main thread ended.");
    }
}
