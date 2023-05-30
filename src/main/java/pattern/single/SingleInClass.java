package pattern.single;

/**
 * 单例模式--内部类
 *
 * @author wangyingjie
 * @version 1.0
 * @date 2021/6/6 22:13
 */
public class SingleInClass {
    /**
     * 构造函数私有化 不被外界实例化
     */
    private SingleInClass() {
    }

    /**
     * 1.静态内部类不会随着外部类的创建而实例化
     * 2.当且仅当静态内部类的静态方法/其构造方法/静态域被调用时 内部类才会被加载
     */
    private static class InnerClass {
        public InnerClass() {
            System.out.println("静态内部类被实例化");
        }

        public final static SingleInClass singleInclass = new SingleInClass();
    }

    public static SingleInClass getInstance() {
        System.out.println("静态内部类的静态成员变量被调用");
        return InnerClass.singleInclass;
    }

    public void hello() {
        System.out.println("这是静态内部类实现的单例模式");
    }
}
