package learnjava.multithreading;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        System.out.println("Main method started!");

        ProducerConsumerQueue queue = new ProducerConsumerQueue(3);

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(5000);
                queue.produce("Suresh");
                queue.produce("Shiva");
                queue.produce("Sita");
                queue.produce("Rama"); // Should wait here if the queue is full
            } catch (InterruptedException e) {
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000);
                queue.consume();
                queue.consume();
                queue.consume();
                queue.consume(); // Should wait here if the queue is empty
            } catch (InterruptedException e) {
            }
        });

        producer.start();
        consumer.start();

        System.out.println("Main method ended!");
    }
}
