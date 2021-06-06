package design_pattern.single;

/**
 * 单例模式 --饿汉式
 */
public class SingleHungry {

    private SingleHungry(){
    }

    private static final SingleHungry instrence = new SingleHungry();

    public static final SingleHungry getInstrence() {
        return instrence;
    }
}
