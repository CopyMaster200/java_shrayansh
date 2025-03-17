package multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " thread running");
        //runnableThread();

        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "Task completed by callable thread " + Thread.currentThread().getName();
        };

        FutureTask<String> futureTask = new FutureTask<>(task);
        Thread t = new Thread(futureTask);
        t.start();

        try {
            // Get the result
            System.out.println("Result: " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runnableThread() {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running");
        });
//        t.setName("Single");
        t.start();
    }
}
