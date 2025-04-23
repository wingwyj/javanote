package pattern.single;

/**
 * @description: 懒汉式（线程安全）
 * @author wyj
 * @version 1.0
 * @date 2025/4/23
 */
public class SingleLazySync {
    private SingleLazySync() {
    }

    private static SingleLazySync singleLazySync;

    public static synchronized SingleLazySync getInstance() {
        if (singleLazySync == null) {
            singleLazySync = new SingleLazySync();
        }
        return singleLazySync;
    }
}
