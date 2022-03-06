package jdk.proxy.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ Author wyj
 * @ Date 2022/3/5
 */
public class DebugInvocationHandler implements InvocationHandler {
    // 被代理对象
    private Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理---执行方法前增强" + method.getName());
        method.invoke(target, args);
        System.out.println("JDK动态代理---执行方法后增强"  + method.getName());
        return null;
    }
}
