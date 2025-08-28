package thread.threadlocal;

/**
 * @ Author wyj
 * @ Date 2022/4/28
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> th = ThreadLocal.withInitial(() -> 0);

        new Thread(()->{
            th.set(111);
            th.set(222);
            System.out.println("线程A " + th.get());
        }, "thread-A").start();

        new Thread(()->{
            th.set(111);
            System.out.println("线程B " + th.get());
        }, "thread-B").start();

        System.out.println(th.get());
    }
}
