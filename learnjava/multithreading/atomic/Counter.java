package learnjava.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger count;

    Counter(int initialVal) {
        count = new AtomicInteger(initialVal);
    }

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public void incrementByVal(int jump) {
        count.addAndGet(jump);
    }
}
