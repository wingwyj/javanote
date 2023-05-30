package thread.singleton;

/**
 * 懒汉模式
 * @ Author wyj
 * @ Date 2022/6/28
 */
public class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy() {
    }
    public static SingletonLazy getInstance() {
        if (null == instance) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
