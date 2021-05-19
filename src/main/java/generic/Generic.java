package generic;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/18 23:42
 *
 *  泛型类
 */
public class Generic<T> {

    private T t;

    public Generic(T t) {
        this.t = t;
    }

    public T getValue() {
        return t;
    }
}
