package learnjava.collection;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        queuePeekElement();
        queueOfferPoll();
        queueAddRemove();
    }

    private static void queuePeekElement() {

        System.out.println("queuePeekElement: ");
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Element: " + queue.element());

        queue.poll();

        System.out.println("Peek: " + queue.peek()); // peek will return null
        try {
            // When queue is empty and trying to see an element using element() method. Then you will get an exception.
            System.out.println("Element: " + queue.element());
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }

    private static void queueOfferPoll() {
        System.out.println("queueOfferPoll: ");
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        // When queue is empty and try to remove element using poll() then we will get null
        System.out.println(queue.poll());

    }

    private static void queueAddRemove() {
        System.out.println("queueAddRemove: ");
        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(1);
        queue.add(2);
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);
        try {
            // When queue is empty and trying to remove an element. Then you will get exception.
            queue.remove();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
    }
}
