package pattern.observer;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/7/25
 */
public class ObserverTest {
    public static void main(String[] args) {
        // 气象站 统计温度
        WeatherStation weatherStation = new WeatherStation();
        // 手机显示问题，观察气象站的问题变化
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        weatherStation.registerObserver(phoneDisplay);

        weatherStation.setTemperature(10);
    }
}
