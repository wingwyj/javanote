package pattern.proxy;


/**
 * @Description: 设计模式---代理模式之静态代理
 */
public class StaticProxy {

    public static void main(String[] args) {
        new PersonProxy(new Person()).happyMerry();
    }
}

//定义统一接口
interface Merry {
    void happyMerry();
}

class Person implements Merry {
    public void happyMerry() {
        System.out.println("要愉快的结婚了。。。。");
    }
}

class PersonProxy implements Merry {

    private Merry target;

    public PersonProxy(Merry tar) {
        this.target = tar;
    }

    public void happyMerry() {
        before();
        this.target.happyMerry();
        affter();
    }

    void before() {
        System.out.println("为婚礼布置新房。。。。。。");
    }

    void affter() {
        System.out.println("婚礼结束。。。。。。");
    }
}
