package thread.mythread;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/5/2
 */
public class InterfaceRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("这是通过实现Runable接口方式创建的线程");
    }
}
