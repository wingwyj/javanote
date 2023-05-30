package thread.abc.abcLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author wyj
 * @ Date 2022/7/1
 */
public class ThreadPrinterLockTest {
    static Lock lock = new ReentrantLock();
    static int index = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (index % 3 == 1) {
                        System.out.print("B");
                        index++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (index % 3 == 0) {
                        System.out.print("A");
                        index++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (index % 3 == 2) {
                        System.out.print("C");
                        index++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
