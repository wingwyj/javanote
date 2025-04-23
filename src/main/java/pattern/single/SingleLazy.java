package pattern.single;

/**
 * 单例模式 -- 懒汉模式
 * 线程不安全
 */
public class SingleLazy {
    private SingleLazy() {
    }

    private static SingleLazy INSTANCE = null ;

    public static SingleLazy getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingleLazy();
        }
        return INSTANCE;
    }
}
