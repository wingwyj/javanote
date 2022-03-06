package jdk.proxy.dynamic_proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @ Author wyj
 * @ Date 2022/3/5
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的加载类
                target.getClass().getInterfaces(), // 代理类需要实现的接口
                new DebugInvocationHandler(target) // 被代理对象对应的InvocationHandler实现类
        );
    }
}
