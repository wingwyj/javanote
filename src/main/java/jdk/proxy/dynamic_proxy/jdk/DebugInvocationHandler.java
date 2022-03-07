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
    
    /**
     * 从界面复制的描述：
     * InvocationHandler 处理代理实例上的方法调用并返回结果。 当在与其关联的代理实例上调用方法时，将在调用处理程序上调用此方法。
     * 指定者：
     * invoke接口InvocationHandler
     * 参数：
     * proxy - 调用该方法的代理实例
     * method – 与在代理实例上调用的接口方法对应的Method实例。 Method对象的声明类将是该方法声明所在的接口，它可能是代理类继承该方法所通过的代理接口的超接口。
     * args – 包含在代理实例的方法调用中传递的参数值的对象数组，如果接口方法不接受参数，则为null 。 原始类型的参数被包装在适当的原始包装类的实例中，例如java.lang.Integer或java.lang.Boolean 。
     * 返回：
     * 从代理实例上的方法调用返回的值。 如果接口方法声明的返回类型是原始类型，则该方法返回的值必须是对应的原始包装类的实例； 否则，它必须是可分配给声明的返回类型的类型。 如果此方法返回的值为null且接口方法的返回类型为原始类型，则代理实例上的方法调用将抛出NullPointerException 。 如果此方法返回的值与上述接口方法声明的返回类型不兼容，则代理实例上的方法调用将抛出ClassCastException 。
     * 抛出：
     * Throwable – 从代理实例的方法调用中抛出的异常。 异常的类型必须可分配给在接口方法的throws子句中声明的任何异常类型，或分配给未经检查的异常类型java.lang.RuntimeException或java.lang.Error 。 如果此方法抛出的已检查异常不可分配给接口方法的throws子句中声明的任何异常类型，则包含此方法抛出的异常的UndeclaredThrowableException将被该方法上的方法调用抛出代理实例。
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理---执行方法前增强" + method.getName());
        method.invoke(target, args);
        System.out.println("JDK动态代理---执行方法后增强"  + method.getName());
        return null;
    }
}
