package thread.singleton;

/**
 * 饿汉式
 * @ Author wyj
 * @ Date 2022/7/2
 */
public class SingletonHungry {
    private SingletonHungry() {
    }
    private static SingletonHungry instance = new SingletonHungry();

    public static SingletonHungry getInstance() {
        return instance;
    }
}
