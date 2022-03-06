package jdk.proxy.dynamic_proxy.jdk;

import jdk.proxy.SmsService;
import jdk.proxy.SmsServiceImpl;

/**
 * @ Author wyj
 * @ Date 2022/3/5
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        SmsService smsService = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("JDK动态代理发送短信");
    }
}
