package learnjava.multithreading;

import java.util.ArrayDeque;

public class ProducerConsumerQueue {

    private ArrayDeque<String> queue;

    ProducerConsumerQueue(int size) {
        queue = new ArrayDeque<>(size);
    }

    public synchronized void produce(String name) {
        while (queue.size() == 3) {
            try {
                System.out.println("Producer is waiting since the buffer is full!");
                wait();
            } catch (InterruptedException e) {
                // exception handling
            }
        }
        queue.offer(name);
        System.out.println("Producer added " + name + " & notifying all threads!");
        notifyAll();
    }

    public synchronized String consume() {
        String retVal;
        while (queue.isEmpty()) {
            try {
                System.out.println("Consumer is waiting, since buffer is empty!");
                wait();
            } catch (InterruptedException e) {
                // exception handling
            }
        }
        retVal = queue.poll();
        System.out.println("Consumer consumed item " + retVal);
        notifyAll();
        return retVal;
    }
}
