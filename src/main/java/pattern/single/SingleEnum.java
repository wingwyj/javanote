package pattern.single;

/**
 * 单例模式--枚举实现
 * @author wangyingjie
 * @version 1.0
 * @date 2021/6/6 22:10
 */
public enum SingleEnum {
    INSTANCE;

    public void hello() {
        System.out.println("这是一个枚举实现的单例模式");
    }
}
