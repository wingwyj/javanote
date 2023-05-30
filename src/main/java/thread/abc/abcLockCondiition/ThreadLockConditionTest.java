package thread.abc.abcLockCondiition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author wyj
 * @ Date 2022/7/2
 */
public class ThreadLockConditionTest {
    static ReentrantLock lock = new ReentrantLock();
    static Condition lockA = lock.newCondition();
    static Condition lockB = lock.newCondition();
    static Condition lockC = lock.newCondition();

    static int index = 0;
    public static void main(String[] args) {



        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (index % 3 != 0) {
                       lockA.await();
                    }
                    System.out.print("A");
                    index++;
                    lockB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (index % 3 != 1) {
                        lockB.await();
                    }
                    System.out.print("B");
                    index++;
                    lockC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (index % 3 != 2) {
                        lockC.await();
                    }
                    System.out.print("C");
                    index++;
                    lockA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
