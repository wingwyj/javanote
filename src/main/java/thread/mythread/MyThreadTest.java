package thread.mythread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ Author wyj
 * @ Date 2022/7/1
 */
public class MyThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 继承Thread类创建线程
        new ExtendThread().start();
        // 实现Runnable接口创建线程
        new Thread(new InterfaceRunable()).start();

        // 实现Callable接口创建线程
        FutureTask<String> futureTask = new FutureTask<>(new InterfaceCallable());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        System.out.println("等待结果的产生");

    }
}
