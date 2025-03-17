package designpatterns;

public class TestPatterns {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);

        SingletonLock singletonLock1 = SingletonLock.getInstance();
        SingletonLock singletonLock2 = SingletonLock.getInstance();
        System.out.println(singletonLock1 == singletonLock2);

        BillPughSingleton obj1 = BillPughSingleton.getInstance();
        BillPughSingleton obj2 = BillPughSingleton.getInstance();
        System.out.println(obj1 == obj2);
    }
}
