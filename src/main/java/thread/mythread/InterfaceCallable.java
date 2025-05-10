package thread.mythread;

import java.util.concurrent.Callable;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/5/2
 */
public class InterfaceCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return  "这是通过实现callable接口开启的异步获取结果的线程";
    }
}
