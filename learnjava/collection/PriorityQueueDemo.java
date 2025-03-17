package learnjava.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Priority Queue will follow Level Order Traversal
 * Default to min heap
 * using custom Comparator we can change it to max heap.
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
//        minHeap();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((var x, var y) -> y - x);
        maxPQ.add(5);
        maxPQ.add(2);
        maxPQ.add(8);
        maxPQ.add(1);

        System.out.println(maxPQ);
    }

    private static void minHeap() {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(5);
        minPQ.add(2);
        minPQ.add(8);
        minPQ.add(1);

        System.out.println(minPQ);
        minPQ.forEach(element -> System.out.println(element));

        int removed;
        while (!minPQ.isEmpty()) {
            removed = minPQ.poll();
            System.out.println("Removing from top: " + removed);
        }
    }
}
