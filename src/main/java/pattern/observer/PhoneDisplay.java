package pattern.observer;

/**
 * 观察者模式-观察者
 * @author wyj
 * @version 1.0
 * @date 2025/7/25
 */
public class PhoneDisplay implements Observer{
    @Override
    public void update(Subject subject) {
        if (subject instanceof WeatherStation) {
            WeatherStation weatherStation = (WeatherStation) subject;
            System.out.println("手机显示温度：" + weatherStation.getTemperature());
        }

    }
}
