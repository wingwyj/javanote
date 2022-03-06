package jdk.proxy.static_proxy;

import jdk.proxy.SmsService;
import jdk.proxy.SmsServiceImpl;

/**
 * @ Date 2022/3/5
 * @ Author wyj
 */
public class SmsProxy  implements SmsService {

    private SmsServiceImpl smsService;

    public SmsProxy(SmsServiceImpl smsService) {
        this.smsService = smsService;
    }

    @Override
    public void send(String message) {
        System.out.println("发送短信前曾强");
        smsService.send(message);
        System.out.println("发送短信后增强");
    }

    public static void main(String[] args) {
        SmsProxy proxy = new SmsProxy(new SmsServiceImpl());
        proxy.send("发送短信通知");
    }
}
