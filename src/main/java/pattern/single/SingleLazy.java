package pattern.single;

/**
 * 单例模式 -- 懒汉模式
 */
public class SingleLazy {
    private SingleLazy() {
    }

    private static SingleLazy instance = null ;

    public static SingleLazy getInstance() {
        if (instance == null) {
            instance = new SingleLazy();
        }
        return instance;
    }
}
