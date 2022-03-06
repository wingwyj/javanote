package jdk.proxy;

/**
 * @ Date 2022/3/5
 * @ Author wyj
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
