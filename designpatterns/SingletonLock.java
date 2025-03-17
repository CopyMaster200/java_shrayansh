package designpatterns;

public class SingletonLock {
    private static volatile SingletonLock singletonLock;

    private SingletonLock() {
    }

    public static SingletonLock getInstance() {
        if (singletonLock == null) { // check without locking
            synchronized (Singleton.class) {
                if (singletonLock == null) { // check with locking
                    singletonLock = new SingletonLock();
                }
            }
        }
        return singletonLock;
    }
}
