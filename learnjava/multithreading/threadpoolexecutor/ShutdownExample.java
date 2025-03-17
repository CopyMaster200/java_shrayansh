package learnjava.multithreading.threadpoolexecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ShutdownExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

//        Future<?> future =
                executor.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("New task completed!");
        });

        executor.shutdown();
//        future.get(); // It will ask main thread to wait till its task is completed.
        System.out.println("Main Thread completed!");
    }
}
