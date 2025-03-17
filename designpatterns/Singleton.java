package designpatterns;

public class Singleton {

    private static final Singleton SINGLETON = new Singleton(); //EAGER no need of checking thread safe or instance available or not

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SINGLETON;
    }
}
