package learnjava.collection;

import java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {

        stackOfferFirstPollFirst();
//        stackPushPop();
//        queueWithOfferPoll();
//        queueWithAddRemove();

    }

    private static void stackOfferFirstPollFirst() {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(1);
        stack.offerFirst(2);
        stack.offerFirst(3);
        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pollFirst());
        }
        System.out.println(stack.pollFirst());
    }

    private static void stackPushPop() {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.pop());
    }

    private static void queueWithOfferPoll() {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("Suresh");
        queue.offer("Ramesh");
        queue.offer("Mahesh");

        System.out.println("Queue: " + queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println(queue.poll());
    }

    private static void queueWithAddRemove() {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("Suresh");
        queue.add("Ramesh");
        queue.add("Mahesh");

        System.out.println("Queue: " + queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        System.out.println(queue.remove());
    }
}
