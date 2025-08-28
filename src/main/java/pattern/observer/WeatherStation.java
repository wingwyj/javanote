package pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式-具体主题
 * @author wyj
 * @version 1.0
 * @date 2025/7/25
 */
public class WeatherStation implements  Subject{
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
