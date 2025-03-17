package learnjava.multithreading.threadpoolexecutor;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(),
                new CustomRejectionHandler());

        executor.allowCoreThreadTimeOut(true);

        for (int i = 1; i <= 7; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    // Exception handling
                }
                System.out.println("Task processed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}

/**
 * Using CustomThreadFactory you can add properties for thread.
 */
class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);
        return thread;
    }
}

class CustomRejectionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected " + r.toString());
    }
}