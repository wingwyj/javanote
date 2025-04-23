package pattern.single;

/**
 * 单例模式 - 双重校验锁
 * @author wyj
 * @version 1.0
 * @date 2025/4/23
 */
public class SingleDoubleCheck {
    private SingleDoubleCheck() {
    }

    private volatile SingleDoubleCheck singleDoubleCheck;

    public SingleDoubleCheck getInstance() {
        if (singleDoubleCheck == null) {
            synchronized (SingleDoubleCheck.class) {
                if (singleDoubleCheck == null) {
                    singleDoubleCheck = new SingleDoubleCheck();
                }
            }
        }
        return singleDoubleCheck;
    }
}
