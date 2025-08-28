package pattern.observer;

/**
 * 观察者模式-观察者接口
 * 职责：
 *   定义更新接口，接收主题通知
 * @author wyj
 * @version 1.0
 * @date 2025/7/25
 */
public interface Observer {
    void update(Subject subject);
}
