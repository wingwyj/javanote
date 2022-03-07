package jdk.proxy.dynamic_proxy.jdk;

import jdk.proxy.SmsService;
import jdk.proxy.SmsServiceImpl;

/**
 * @ Author wyj
 * @ Date 2022/3/5
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        // 通过该方法设置可以查看动态生成的代理类
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\develop\\noteTip\\src\\main\\java\\com\\notetip\\test\\jdk\\dynamicproxy\\cglib\\");
        
        SmsService smsService = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("JDK动态代理发送短信");
        
        // new JdkProxyTest().generateProxy();
    }
    
    public void generateProxy() {
        String name = "SmServiceImplProxy";
        byte[] bytes = ProxyGenerator.generateProxyClass(
                name, new Class[]{SmService.class});
        try (FileOutputStream out = new FileOutputStream(name + ".class");) {
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
