package thread.abc.abcSync;

/**
 * @ Author wyj
 * @ Date 2022/7/1
 */
public class ThreadPrinterTest {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();


        Thread threadA = new Thread(new ThreadPrinter("A", c, a));
        Thread threadB = new Thread(new ThreadPrinter("B", a, b));
        Thread threadC = new Thread(new ThreadPrinter("C", b, c));

        // 保证线程的启动顺序
        try {
            threadA.start();
            Thread.sleep(10);
            threadB.start();
            Thread.sleep(10);
            threadC.start();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
