package generic;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/18 23:05
 */
public abstract class AbstractEntity<T extends Employee> {
    public abstract boolean checkAge(T t);
}
