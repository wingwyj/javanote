package thread.singleton;

/**
 * @ Author wyj
 * @ Date 2022/7/2
 */
public class SingletonStaticInner {
    private SingletonStaticInner(){}

    private static SingletonStaticInner instance;

    private static class Instance{
        private static SingletonStaticInner instance = new SingletonStaticInner();
    }

    public static SingletonStaticInner getInstance() {
        return Instance.instance;
    }
}
