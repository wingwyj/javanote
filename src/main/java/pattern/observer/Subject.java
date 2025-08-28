package pattern.observer;


/**
 * 观察者模式-主题接口
 * 职责：
 *  维护观察者列表（添加/删除观察者）
 *  状态变化时通知所有观察者
 * @author wyj
 * @version 1.0
 * @date 2025/7/25
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
