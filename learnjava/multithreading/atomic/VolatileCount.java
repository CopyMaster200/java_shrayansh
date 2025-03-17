package learnjava.multithreading.atomic;

public class VolatileCount {
    private volatile int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
