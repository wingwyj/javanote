package thread.mythread;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/5/2
 */
public class ExtendThread extends Thread{
    @Override
    public void run() {
        System.out.println("这是通过继承Thread的方式创建的线程");
    }
}
