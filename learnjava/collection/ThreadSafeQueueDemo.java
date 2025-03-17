package learnjava.collection;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadSafeQueueDemo {
    public static void main(String[] args) {
        // Thread safe version for PriorityQueue
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
        priorityBlockingQueue.offer(1);
        priorityBlockingQueue.offer(2);

        System.out.println(priorityBlockingQueue.peek());

        System.out.println(priorityBlockingQueue);

        // Thread safe version for ArrayDeque
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        concurrentLinkedDeque.offerFirst(1);
        concurrentLinkedDeque.offerLast(2);

        System.out.println(concurrentLinkedDeque);
    }
}
