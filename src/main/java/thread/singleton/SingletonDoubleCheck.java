package thread.singleton;

/**
 * @ Author wyj
 * @ Date 2022/7/2
 */
public class SingletonDoubleCheck {
    private SingletonDoubleCheck(){
    }
    private static SingletonDoubleCheck instance;

    public static SingletonDoubleCheck getInstance() {
        if (null == instance) {
            synchronized (SingletonDoubleCheck.class) {
                if (null == instance) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
