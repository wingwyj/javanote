package thread.abc.abcSync;

/**
 * 1。保证三个线程的启动顺序
 * 2.执行线程要拿到前一个线程的锁
 * @ Author wyj
 * @ Date 2022/7/1
 */
public class ThreadPrinter implements Runnable {
    private final String name;
    private final Object prev;
    private final Object self;

    public ThreadPrinter(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        // 总共次数
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    self.notifyAll();
                }
                try {
                    if (count == 0) {
                        prev.notifyAll();
                    } else {
                        prev.wait(); // 释放锁等待
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
