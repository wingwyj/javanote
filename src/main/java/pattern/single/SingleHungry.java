package pattern.single;

/**
 * 单例模式 --饿汉式
 * 特点：
 * 线程安全：实例在类加载时即被创建，JVM保证初始化过程的唯一性。
 * 无延迟加载：可能造成资源浪费，若实例初始化成本高且未被使用。
 * 防反射攻击：需在构造器中添加判空逻辑阻止反射创建新实例。
 */
public class SingleHungry {

    private SingleHungry(){
    }

    private static final SingleHungry INSTANCE = new SingleHungry();

    public static SingleHungry getInstance() {
        return INSTANCE;
    }
}
