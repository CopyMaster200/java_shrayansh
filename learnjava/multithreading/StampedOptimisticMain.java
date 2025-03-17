package learnjava.multithreading;

public class StampedOptimisticMain {
    public static void main(String[] args) {
        StampedOptimisticResource resource = new StampedOptimisticResource();

        Thread t1 = new Thread(() -> {
            resource.produce();
        });

        Thread t2 = new Thread(() -> {
            resource.consume();
        });

        t1.start(); // It will intentionally sleep for 6ms so write operation can happen which lead to change in stamp.
                    // So t1 will fail validation on stamp and fall under rollback.
        t2.start(); // It will perform write operation change the stamp.
    }
}
